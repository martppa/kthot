package net.asere.kotlin.js.dsl.type.lambda.l3

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda3Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> internal constructor(
    value: String,
    isNullable: Boolean
) :
    JsReferenceSyntax<JsLambda3<Param1, Param2, Param3>>(value, isNullable), JsLambda3<Param1, Param2, Param3> {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.syntax(
    value: String,
    isNullable: Boolean = false
): JsLambda3<Param1, Param2, Param3> =
    JsLambda3Syntax(value, isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false
): JsLambda3<Param1, Param2, Param3> =
    JsLambda3Syntax(value, isNullable)