package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSFunctionDeclaration

val KSFunctionDeclaration.parametersDefinitionString: String get() = parameters.mapIndexed { index, parameter ->
    "${parameter.name?.asString() ?: "p$index"}: ${parameter.type.resolve().definitionName}"
}.joinToString(", ")

val KSFunctionDeclaration.parametersNames: List<String> get() = parameters.mapIndexed { index, parameter ->
    parameter.name?.asString() ?: "p$index"
}

val KSFunctionDeclaration.parametersNamesString: String get() = parameters.mapIndexed { index, parameter ->
    parameter.name?.asString() ?: "p$index"
}.joinToString(", ")