package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeArgument
import com.google.devtools.ksp.symbol.Visibility

fun KSClassDeclaration.getJsAvailableFunctions(resolver: Resolver) = declarations
    .filterIsInstance<KSFunctionDeclaration>()
    .filter { it.getVisibility() == Visibility.PUBLIC }
    .filter { !it.isConstructor() }
    .filter { it.returnType?.resolve()?.declaration.isJsElement(resolver) }

fun KSClassDeclaration.getJsAvailableProperties(resolver: Resolver) = getAllProperties()
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

fun KSClassDeclaration.getDeclarativeName(name: String? = null): String {
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

    val whereClause = typeParameters.filter { it.bounds.toList().size > 1 }.map { parameter ->
        parameter.bounds.filter { !it.resolve().declaration.isAny() }
            .map { bound ->  "${parameter.name.asString()} : ${bound.resolve().definitionName}" }
            .joinToString()
    }.filter { it.isNotBlank() }.let { if (it.isEmpty()) "" else " where ${it.joinToString()}" }

    stringBuilder.append(whereClause)

    return stringBuilder.toString()
}