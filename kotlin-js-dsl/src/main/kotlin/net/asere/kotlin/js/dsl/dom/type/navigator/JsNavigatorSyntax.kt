package net.asere.kotlin.js.dsl.dom.type.navigator

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

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