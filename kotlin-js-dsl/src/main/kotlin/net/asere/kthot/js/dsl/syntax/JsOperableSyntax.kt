package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.Operable

internal class JsOperableSyntax(element: JsElement): JsSyntax(element), Operable

fun JsElement.toOperable(): Operable = JsOperableSyntax(this)