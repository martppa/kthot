package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.*
import net.asere.kthot.js.dsl.ksp.processor.jsApiClassAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsApiFunctionModuleAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsClassAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsConstructorAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsFunctionAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsFunctionModuleAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsImportableAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsNullableAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsPropertyAnnotationName

/**
 * Returns a sequence of available functions annotated as @JsFunction
 */
fun KSClassDeclaration.getJsAvailableFunctions(resolver: Resolver): Sequence<KSFunctionDeclaration> = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter {
        it.annotations.find { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsFunctionAnnotationName
        } != null
    }
    .filter { it.getVisibility() == Visibility.PUBLIC }
    .filter { !it.isConstructor() }
    .filter { it.returnType?.resolve()?.declaration.isJsElement(resolver) }

/**
 * Returns a sequence of available properties annotated as @JsFunction
 */
fun KSClassDeclaration.getJsAvailableProperties(resolver: Resolver) = getAllProperties()
    .filter {
        it.annotations.find { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsPropertyAnnotationName
        } != null
    }
    .filter { it.getVisibility() == Visibility.PUBLIC && it.isJsElement(resolver) }

/**
 * Searches for all super classes that are interfaces and returns them
 */
val KSClassDeclaration.superTypeInterfaces: List<KSType>
    get() = superTypes
        .filter {
            it.resolve().declaration is KSClassDeclaration &&
                    (it.resolve().declaration as KSClassDeclaration).classKind == ClassKind.INTERFACE
        }
        .map { it.resolve() }.toList()

/**
 * Tells whether the provided declaration is a subclass or not
 */
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

/**
 * Whether this declaration is nullable or nor
 */
fun KSClassDeclaration.isNullable(): Boolean = annotations.find {
    it.annotationType.resolve().declaration.qualifiedName?.asString() == jsNullableAnnotationName
} != null

/**
 * The name provided to annotation at declaration
 */
val KSClassDeclaration.jsName: String
    get() {
        val jsClassAnnotation = annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsClassAnnotationName ||
                    it.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiClassAnnotationName ||
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiFunctionModuleAnnotationName ||
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsFunctionModuleAnnotationName
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

/**
 * Returns a definition string of all generic types in the class including boundaries.
 * For example, <T : JsString, C : JsElement>. If none is found, it returns an empty string.
 */
fun KSClassDeclaration.genericTypesDeclarationString(modifier: String? = null): String {
    val stringBuilder = StringBuilder()
    val genericTypesDeclarations = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        val bounds = parameter.bounds.filter { !it.resolve().declaration.isAny() }.toList()
        when (bounds.size) {
            1 -> genericTypesDeclarations.add(
                "${
                    modifier?.let {
                        "$it "
                    }.orEmpty()
                }${parameter.name.asString()} : ${bounds.first().resolve().definitionName}"
            )

            else -> genericTypesDeclarations.add(
                "${
                    modifier?.let {
                        "$it "
                    }.orEmpty()
                }${parameter.name.asString()}"
            )
        }
    }
    if (genericTypesDeclarations.isNotEmpty()) {
        stringBuilder.append("<")
        stringBuilder.append(genericTypesDeclarations.joinToString(", "))
        stringBuilder.append(">")
    }
    return stringBuilder.toString()
}

/**
 * Returns the where clause for multiple generics bounding. If none is found, it returns an empty string.
 */
val KSClassDeclaration.whereClauseString: String
    get() {
        val whereClause = typeParameters.filter { it.bounds.toList().size > 1 }.map { parameter ->
            parameter.bounds.filter { !it.resolve().declaration.isAny() }
                .map { bound -> "${parameter.name.asString()} : ${bound.resolve().definitionName}" }
                .joinToString()
        }.filter { it.isNotBlank() }.let { if (it.isEmpty()) "" else "where ${it.joinToString()}" }
        return whereClause
    }

/**
 * The list of constructors defined
 */
val KSClassDeclaration.constructors: List<KSFunctionDeclaration>
    get() {
        return declarations
            .filterIsInstance<KSFunctionDeclaration>()
            .filter { it.simpleName.asString().isEmpty() }
            .toList()
    }

/**
 * The list of properties defined in the class
 */
val KSClassDeclaration.properties: List<KSPropertyDeclaration>
    get() {
        return declarations
            .filterIsInstance<KSPropertyDeclaration>()
            .toList()
    }

/**
 * Returns a list of constructors defined in the class that were annotated with @JsConstructor
 */
fun KSClassDeclaration.findJsConstructors(): List<KSFunctionDeclaration> = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter { function ->
        function.annotations.any { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsConstructorAnnotationName
        }
    }
    .toList()

/**
 * Returns a list of functions defined in the class that were annotated with @JsFunction
 */
fun KSClassDeclaration.findJsFunctions(): List<KSFunctionDeclaration> = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter { function ->
        function.annotations.any { annotation ->
            annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsFunctionAnnotationName
        }
    }
    .toList()

fun KSClassDeclaration.isInterface(): Boolean = classKind == ClassKind.INTERFACE

fun KSClassDeclaration.getImportPath(): String = "${
    packageName.asString().replace(".", "/")
}/${jsName}.js"

val KSClassDeclaration.isImportable: Boolean get() = annotations.any { annotation ->
    annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsImportableAnnotationName
}

val KSClassDeclaration.isApi: Boolean get() = annotations.any { annotation ->
    annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiClassAnnotationName ||
    annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiFunctionModuleAnnotationName
}

val KSClassDeclaration.isMarkedAsClass: Boolean get() = annotations.any { annotation ->
    annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiClassAnnotationName ||
    annotation.annotationType.resolve().declaration.qualifiedName?.asString() == jsClassAnnotationName
}

fun KSClassDeclaration.getDeclaration(name: String? = null): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append(name ?: this.name)
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        val bounds = parameter.bounds.filter { !it.resolve().declaration.isAny() }.toList()
        when (bounds.size) {
            1 -> genericTypes.add("${parameter.name.asString()} : ${bounds.first().resolve().definitionName}")
            else -> genericTypes.add(parameter.name.asString())
        }
    }
    if (genericTypes.isNotEmpty()) {
        stringBuilder.append("<")
        stringBuilder.append(genericTypes.joinToString(", "))
        stringBuilder.append(">")
    }
    stringBuilder.append(" : ")
    val superTypes = superTypeInterfaces
    stringBuilder.append(
        if (superTypes.isNotEmpty()) superTypes.joinToString(", ") { it.definitionName } else "JsObject"
    )

    stringBuilder.append(" $whereClauseString")

    return stringBuilder.toString()
}