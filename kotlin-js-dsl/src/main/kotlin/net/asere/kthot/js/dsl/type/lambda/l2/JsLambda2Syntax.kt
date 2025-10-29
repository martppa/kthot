package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda2Syntax<Param1 : JsValue, Param2 : JsValue> internal constructor(value: String) :
    JsReferenceSyntax<JsLambda2<Param1, Param2>>(value), JsLambda2<Param1, Param2> {
    internal constructor(value: JsElement) : this("$value")
}

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.syntax(
    value: String,
): JsLambda2<Param1, Param2> =
    JsLambda2Syntax(value)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.syntax(
    value: JsElement,
): JsLambda2<Param1, Param2> =
    JsLambda2Syntax(value)