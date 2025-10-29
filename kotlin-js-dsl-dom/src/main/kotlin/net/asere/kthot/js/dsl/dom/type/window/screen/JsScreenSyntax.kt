package net.asere.kthot.js.dsl.dom.type.window.screen

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsScreen].
 */
class JsScreenSyntax(value: String) : JsReferenceSyntax<JsScreen>(value), JsScreen {
    constructor(value: JsElement) : this("$value")
}

fun JsScreen.Companion.syntax(value: String): JsScreen = JsScreenSyntax(value)
fun JsScreen.Companion.syntax(value: JsElement): JsScreen = JsScreenSyntax(value)