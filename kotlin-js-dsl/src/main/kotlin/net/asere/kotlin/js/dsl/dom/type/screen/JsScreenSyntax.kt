package net.asere.kotlin.js.dsl.dom.type.screen

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsScreen].
 */
class JsScreenSyntax(value: String) : JsSyntax(value), JsScreen {
    constructor(value: JsElement) : this("$value")
}

fun JsScreen.Companion.syntax(value: String): JsScreenSyntax = JsScreenSyntax(value)