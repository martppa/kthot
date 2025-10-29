package net.asere.kthot.js.dsl.type.lambda.l5

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda5Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> internal constructor(
    value: String,
) :
    JsReferenceSyntax<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(value),
    JsLambda5<Param1, Param2, Param3, Param4, Param5> {
    internal constructor(value: JsElement) : this("$value")
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.syntax(
    value: String,
): JsLambda5<Param1, Param2, Param3, Param4, Param5> =
    JsLambda5Syntax(value)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.syntax(
    value: JsElement,
): JsLambda5<Param1, Param2, Param3, Param4, Param5> =
    JsLambda5Syntax(value)