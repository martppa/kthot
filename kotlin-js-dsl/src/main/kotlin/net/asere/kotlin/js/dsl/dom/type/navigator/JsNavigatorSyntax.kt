package net.asere.kotlin.js.dsl.dom.type.navigator

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsNavigator].
 */
class JsNavigatorSyntax internal constructor(value: String) : JsSyntax(value), JsNavigator {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNavigator.Companion.syntax(value: String): JsNavigatorSyntax = JsNavigatorSyntax(value)
fun JsNavigator.Companion.syntax(value: JsElement): JsNavigatorSyntax = JsNavigatorSyntax(value)