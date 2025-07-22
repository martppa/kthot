package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.operation.Operable

internal class JsOperableSyntax(element: JsElement): JsSyntax("$element"), Operable

internal fun JsElement.toOperable() = JsOperableSyntax(this)