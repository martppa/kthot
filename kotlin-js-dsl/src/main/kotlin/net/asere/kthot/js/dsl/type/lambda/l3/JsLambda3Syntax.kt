package net.asere.kthot.js.dsl.type.lambda.l3

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda3Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> internal constructor(
    value: String,
) :
    JsReferenceSyntax<JsLambda3<Param1, Param2, Param3>>(value), JsLambda3<Param1, Param2, Param3> {
    internal constructor(value: JsElement) : this("$value")
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.syntax(
    value: String,
): JsLambda3<Param1, Param2, Param3> =
    JsLambda3Syntax(value)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.syntax(
    value: JsElement,
): JsLambda3<Param1, Param2, Param3> =
    JsLambda3Syntax(value)