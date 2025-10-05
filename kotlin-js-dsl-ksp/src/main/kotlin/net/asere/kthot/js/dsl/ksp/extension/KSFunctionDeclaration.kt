package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSFunctionDeclaration

/**
 * Returns the list of parameters of the function as definition string. For example,
 * "value1: String, value2: String, value3: Int"
 */
val KSFunctionDeclaration.parametersDefinitionString: String get() = parameters.mapIndexed { index, parameter ->
    "${parameter.name?.asString() ?: "p$index"}: ${parameter.type.resolve().definitionName}"
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