package net.asere.kthot.js.dsl.dom.type.window.navigator

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsNavigator].
 */
class JsNavigatorSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsNavigator>(value), JsNavigator {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNavigator.Companion.syntax(value: String): JsNavigator =
    JsNavigatorSyntax(value)

fun JsNavigator.Companion.syntax(value: JsElement): JsNavigator =
    JsNavigatorSyntax(value)