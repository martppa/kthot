package net.asere.kthot.js.dsl.type.lambda.l5

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda5Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> internal constructor(
    value: String,
    isNullable: Boolean
) :
    JsReferenceSyntax<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(value, isNullable),
    JsLambda5<Param1, Param2, Param3, Param4, Param5> {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.syntax(
    value: String,
    isNullable: Boolean = false
): JsLambda5<Param1, Param2, Param3, Param4, Param5> =
    JsLambda5Syntax(value, isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false
): JsLambda5<Param1, Param2, Param3, Param4, Param5> =
    JsLambda5Syntax(value, isNullable)