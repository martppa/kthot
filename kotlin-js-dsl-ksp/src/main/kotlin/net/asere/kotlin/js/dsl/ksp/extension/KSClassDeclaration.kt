package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.*
import net.asere.kotlin.js.dsl.ksp.processor.jsClassAnnotationName
import net.asere.kotlin.js.dsl.ksp.processor.jsConstructorAnnotationName
import net.asere.kotlin.js.dsl.ksp.processor.jsFunctionAnnotationName
import net.asere.kotlin.js.dsl.ksp.processor.jsNullableAnnotationName
import net.asere.kotlin.js.dsl.ksp.processor.jsPropertyAnnotationName

fun KSClassDeclaration.getJsAvailableFunctions(resolver: Resolver) = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter {
        annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsFunctionAnnotationName
        } != null
    }
    .filter { it.getVisibility() == Visibility.PUBLIC }
    .filter { !it.isConstructor() }
    .filter { it.returnType?.resolve()?.declaration.isJsElement(resolver) }

fun KSClassDeclaration.getJsAvailableProperties(resolver: Resolver) = getAllProperties()
    .filter {
        it.annotations.find { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsPropertyAnnotationName
        } != null
    }
    .apply { println(this.joinToString { it.name }) }
    .filter { it.getVisibility() == Visibility.PUBLIC && it.isJsElement(resolver) }

val KSClassDeclaration.superTypeInterfaces: List<KSType>
    get() = superTypes
        .filter {
            it.resolve().declaration is KSClassDeclaration &&
                    (it.resolve().declaration as KSClassDeclaration).classKind == ClassKind.INTERFACE
        }
        .map { it.resolve() }.toList()

fun KSClassDeclaration.isSubclassOf(superClass: KSClassDeclaration): Boolean {
    if (qualifiedName?.asString() == superClass.qualifiedName?.asString()) {
        return true
    }
    for (superTypeRef in superTypes) {
        val superTypeDeclaration = superTypeRef.resolve().declaration
        if (superTypeDeclaration is KSClassDeclaration && !superTypeDeclaration.isAny()) {
            if (superTypeDeclaration.isSubclassOf(superClass)) {
                return true
            }
        }
    }
    return false
}

fun KSClassDeclaration.isNullable(): Boolean = annotations.find {
    it.annotationType.resolve().declaration.qualifiedName?.asString() == jsNullableAnnotationName
} != null

val KSClassDeclaration.jsName: String get() {
    val jsClassAnnotation = annotations.find {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == jsClassAnnotationName
    } ?: return name

    val nameFromAnnotation =
        jsClassAnnotation.arguments.find { it.name?.asString() == "name" }?.value as? String
    val className = if (nameFromAnnotation.isNullOrBlank()) {
        "${if (name.startsWith("Js")) "" else "Js"}${name}"
    } else {
        nameFromAnnotation
    }
    return className
}

fun KSClassDeclaration.genericTypesDeclarationString(modifier: String? = null): String {
    val stringBuilder = StringBuilder()
    val genericTypesDeclarations = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        val bounds = parameter.bounds.filter { !it.resolve().declaration.isAny() }.toList()
        when (bounds.size) {
            1 -> genericTypesDeclarations.add("${modifier?.let { 
                "$it " 
            }.orEmpty()}${parameter.name.asString()} : ${bounds.first().resolve().definitionName}")
            else -> genericTypesDeclarations.add("${modifier?.let { 
                "$it " 
            }.orEmpty()}${parameter.name.asString()}")
        }
    }
    if (genericTypesDeclarations.isNotEmpty()) {
        stringBuilder.append("<")
        stringBuilder.append(genericTypesDeclarations.joinToString(", "))
        stringBuilder.append(">")
    }
    return stringBuilder.toString()
}

val KSClassDeclaration.whereClauseString: String get() {
    val whereClause = typeParameters.filter { it.bounds.toList().size > 1 }.map { parameter ->
        parameter.bounds.filter { !it.resolve().declaration.isAny() }
            .map { bound ->  "${parameter.name.asString()} : ${bound.resolve().definitionName}" }
            .joinToString()
    }.filter { it.isNotBlank() }.let { if (it.isEmpty()) "" else "where ${it.joinToString()}" }
    return whereClause
}

val KSClassDeclaration.genericTypesString: String get() {
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        genericTypes.add(parameter.name.asString())
    }
    if (genericTypes.isEmpty()) return ""
    return "<${genericTypes.joinToString()}>"
}

fun KSClassDeclaration.buildGenericTypesAsString(value: String): String {
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        genericTypes.add(value)
    }
    if (genericTypes.isEmpty()) return ""
    return "<${genericTypes.joinToString()}>"
}

val KSClassDeclaration.genericTypesAsJsValueString: String get() = buildGenericTypesAsString("JsValue")
val KSClassDeclaration.genericTypesAsStarString: String get() = buildGenericTypesAsString("*")

val KSClassDeclaration.constructors: List<KSFunctionDeclaration> get() {
    return declarations
        .filterIsInstance<KSFunctionDeclaration>()
        .filter { it.simpleName.asString().isEmpty() }
        .toList()
}

val KSClassDeclaration.properties: List<KSPropertyDeclaration> get() {
    return declarations
        .filterIsInstance<KSPropertyDeclaration>()
        .toList()
}

fun KSClassDeclaration.findJsConstructors(): List<KSFunctionDeclaration> = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter { function ->
        function.annotations.any { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsConstructorAnnotationName
        }
    }
    .toList()

fun KSClassDeclaration.findJsFunctions(): List<KSFunctionDeclaration> = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter { function ->
        function.annotations.any { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsFunctionAnnotationName
        }
    }
    .toList()