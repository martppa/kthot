package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda4Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> internal constructor(
    value: String,
) :
    JsReferenceSyntax<JsLambda4<Param1, Param2, Param3, Param4>>(value), JsLambda4<Param1, Param2, Param3, Param4> {
    internal constructor(value: JsElement) : this("$value")
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.syntax(
    value: String,
): JsLambda4<Param1, Param2, Param3, Param4> =
    JsLambda4Syntax(value)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.syntax(
    value: JsElement,
): JsLambda4<Param1, Param2, Param3, Param4> =
    JsLambda4Syntax(value)