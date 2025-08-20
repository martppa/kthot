package net.asere.kotlin.js.dsl.type.lambda.l2

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda2Syntax<Param1 : JsValue, Param2 : JsValue> internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsLambda2<Param1, Param2>>(value, isNullable), JsLambda2<Param1, Param2> {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.syntax(
    value: String,
    isNullable: Boolean = false
): JsLambda2<Param1, Param2> =
    JsLambda2Syntax(value, isNullable)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false
): JsLambda2<Param1, Param2> =
    JsLambda2Syntax(value, isNullable)