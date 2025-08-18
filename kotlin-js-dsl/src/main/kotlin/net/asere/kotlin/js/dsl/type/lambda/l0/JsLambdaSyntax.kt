package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsLambdaSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsLambda>(value, isNullable), JsLambda {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsLambda.Companion.syntax(value: String, isNullable: Boolean = false): JsLambda = JsLambdaSyntax(value, isNullable)
fun JsLambda.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsLambda =
    JsLambdaSyntax(value, isNullable)