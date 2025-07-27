package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsNavigator
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsNavigator].
 */
class JsNavigatorSyntax(value: String) : JsSyntax(value), JsNavigator {
    constructor(value: JsElement) : this("$value")
}