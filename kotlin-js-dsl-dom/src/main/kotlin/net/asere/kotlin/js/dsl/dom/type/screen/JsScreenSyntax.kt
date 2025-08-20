package net.asere.kotlin.js.dsl.dom.type.screen

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsScreen].
 */
class JsScreenSyntax(value: String, isNullable: Boolean) : JsReferenceSyntax<JsScreen>(value, isNullable), JsScreen {
    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsScreen.Companion.syntax(value: String, isNullable: Boolean = false): JsScreen = JsScreenSyntax(value, isNullable)
fun JsScreen.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsScreen = JsScreenSyntax(value, isNullable)