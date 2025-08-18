package net.asere.kotlin.js.dsl.type.lambda.l4

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda4Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> internal constructor(
    value: String,
    isNullable: Boolean
) :
    JsReferenceSyntax<JsLambda4<Param1, Param2, Param3, Param4>>(value, isNullable), JsLambda4<Param1, Param2, Param3, Param4> {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.syntax(
    value: String,
    isNullable: Boolean = false
): JsLambda4<Param1, Param2, Param3, Param4> =
    JsLambda4Syntax(value, isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false
): JsLambda4<Param1, Param2, Param3, Param4> =
    JsLambda4Syntax(value, isNullable)