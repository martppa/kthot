package net.asere.kthot.js.dsl.dom.type.window.location

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsLocation].
 */
class JsLocationSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsLocation>(value, isNullable), JsLocation {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsLocation.Companion.syntax(value: String, isNullable: Boolean = false): JsLocation =
    JsLocationSyntax(value, isNullable)

fun JsLocation.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsLocation =
    JsLocationSyntax(value, isNullable)