package net.asere.kthot.js.dsl.dom.type.window.navigator

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsNavigator].
 */
class JsNavigatorSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsNavigator>(value, isNullable), JsNavigator {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsNavigator.Companion.syntax(value: String, isNullable: Boolean = false): JsNavigator =
    JsNavigatorSyntax(value, isNullable)

fun JsNavigator.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsNavigator =
    JsNavigatorSyntax(value, isNullable)