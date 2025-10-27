package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

/**
 * Returns the list of parameters of the function as definition string. For example,
 * "value1: JsStringRef, value2: JsStringRef, value3: JsNumberRef"
 */
val KSFunctionDeclaration.parametersDefinitionString: String get() = parameters.mapIndexed { index, parameter ->
    "${parameter.name?.asString() ?: "p$index"}: ${parameter.type.resolve().definitionName}"
}.joinToString(", ")

/**
 * Returns the list of basic type parameters of the function as definition string. For example,
 * "value1: JsString, value2: JsString, value3: JsNumber"
 */
val KSFunctionDeclaration.parametersDefinitionBasicString: String get() = parameters.mapIndexed { index, parameter ->
    "${parameter.name?.asString() ?: "p$index"}: ${parameter.type.resolve().basicDefinitionName}"
}.joinToString(", ")

/**
 * Returns the list of function's parameters names of the function.
 */
val KSFunctionDeclaration.parametersNames: List<String> get() = parameters.mapIndexed { index, parameter ->
    parameter.name?.asString() ?: "p$index"
}

/**
 * Returns the list of function's parameters as a string. For example,
 * "value1, value2, value3"
 */
val KSFunctionDeclaration.parametersNamesString: String get() = parameters.mapIndexed { index, parameter ->
    parameter.name?.asString() ?: "p$index"
}.joinToString(", ")

/**
 * Returns the where clause for multiple generics bounding. If none is found, it returns an empty string.
 */
val KSFunctionDeclaration.whereClauseString: String
    get() {
        val whereClause = typeParameters.filter { it.bounds.toList().size > 1 }.map { parameter ->
            parameter.bounds.filter { !it.resolve().declaration.isAny() }
                .map { bound -> "${parameter.name.asString()} : ${bound.resolve().definitionName}" }
                .joinToString()
        }.filter { it.isNotBlank() }.let { if (it.isEmpty()) "" else "where ${it.joinToString()}" }
        return whereClause
    }