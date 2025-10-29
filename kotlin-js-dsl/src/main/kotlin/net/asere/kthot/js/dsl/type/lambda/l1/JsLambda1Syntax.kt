package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda1Syntax<Param1 : JsValue> internal constructor(value: String) :
    JsReferenceSyntax<JsLambda1<Param1>>(value), JsLambda1<Param1> {
    internal constructor(value: JsElement) : this("$value")
}

fun <Param1 : JsValue> JsLambda1.Companion.syntax(value: String): JsLambda1<Param1> =
    JsLambda1Syntax(value)

fun <Param1 : JsValue> JsLambda1.Companion.syntax(value: JsElement): JsLambda1<Param1> =
    JsLambda1Syntax(value)