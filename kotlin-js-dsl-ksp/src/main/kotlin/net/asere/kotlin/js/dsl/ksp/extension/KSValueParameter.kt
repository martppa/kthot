package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSValueParameter

fun List<KSValueParameter>.definitionString() = joinToString(", ") {
    val paramName = it.name?.asString()
    val paramType = it.type.resolve().declaration.name
    "$paramName: $paramType"
}

fun List<KSValueParameter>.listString() = joinToString(", ") {
    "${it.name?.asString()}"
}