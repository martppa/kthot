package net.asere.kotlin.js.dsl.type.lambda.l1

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda1Syntax<Param1 : JsValue> internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsLambda1<Param1>>(value, isNullable), JsLambda1<Param1> {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun <Param1 : JsValue> JsLambda1.Companion.syntax(value: String, isNullable: Boolean = false): JsLambda1<Param1> =
    JsLambda1Syntax(value, isNullable)

fun <Param1 : JsValue> JsLambda1.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsLambda1<Param1> =
    JsLambda1Syntax(value, isNullable)