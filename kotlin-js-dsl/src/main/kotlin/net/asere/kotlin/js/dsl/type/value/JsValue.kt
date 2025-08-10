package net.asere.kotlin.js.dsl.type.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsArithmeticalSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.AccessOperation
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.string.JsString

interface JsValue : JsElement, Operable

fun JsValue.raw(syntax: JsSyntax) = JsSyntax(ChainOperation(this, "$syntax"))
fun JsValue.raw(syntax: String) = JsSyntax(ChainOperation(this, syntax))
operator fun JsValue.get(value: JsNumber) = JsArithmeticalSyntax(AccessOperation(this, value))
operator fun JsValue.get(value: JsString) = JsArithmeticalSyntax(AccessOperation(this, value))
operator fun JsValue.get(value: JsValue) = JsArithmeticalSyntax(AccessOperation(this, value))