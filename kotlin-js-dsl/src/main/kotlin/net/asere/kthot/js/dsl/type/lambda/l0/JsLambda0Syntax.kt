package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsLambda0Syntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsLambda0>(value, isNullable), JsLambda0 {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsLambda0.Companion.syntax(value: String, isNullable: Boolean = false): JsLambda0 = JsLambda0Syntax(value, isNullable)
fun JsLambda0.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsLambda0 =
    JsLambda0Syntax(value, isNullable)