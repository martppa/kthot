package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.Operable

internal class JsOperableSyntax(element: JsElement): JsSyntax(element.present()), Operable

internal fun JsElement.toOperable() = JsOperableSyntax(this)