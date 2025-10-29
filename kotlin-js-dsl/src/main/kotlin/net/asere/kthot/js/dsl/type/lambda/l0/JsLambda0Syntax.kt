package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsLambda0Syntax internal constructor(value: String) :
    JsReferenceSyntax<JsLambda0>(value), JsLambda0 {
    internal constructor(value: JsElement) : this("$value")
}

fun JsLambda0.Companion.syntax(value: String): JsLambda0 = JsLambda0Syntax(value)
fun JsLambda0.Companion.syntax(value: JsElement): JsLambda0 =
    JsLambda0Syntax(value)