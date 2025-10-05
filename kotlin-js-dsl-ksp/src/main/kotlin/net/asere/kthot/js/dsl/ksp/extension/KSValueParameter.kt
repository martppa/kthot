package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSValueParameter

/**
 * Returns a string of all parameters and types separated by a comma. For example, value1: JsString, value2: JsNumber
 */
fun List<KSValueParameter>.definitionString() = joinToString(", ") {
    val paramName = it.name?.asString()
    val paramType = it.type.resolve().declaration.name
    "$paramName: $paramType"
}

/**
 * Returns a string of all parameters names separated by a comma. For example, value1, value2
 */
fun List<KSValueParameter>.listString() = joinToString(", ") {
    "${it.name?.asString()}"
}