package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsNavigator
import net.asere.kotlin.js.dsl.dom.type.JsScreen
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsScreen].
 */
class JsScreenSyntax(value: String) : JsSyntax(value), JsScreen {
    constructor(value: JsElement) : this("$value")
}