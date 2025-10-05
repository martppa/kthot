package net.asere.kthot.js.dsl.type.value

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.Operable

interface JsValue : JsElement, Operable

fun JsValue.raw(syntax: JsSyntax) = JsSyntax(ChainOperation(this, "$syntax"))
fun JsValue.raw(syntax: String) = JsSyntax(ChainOperation(this, syntax))