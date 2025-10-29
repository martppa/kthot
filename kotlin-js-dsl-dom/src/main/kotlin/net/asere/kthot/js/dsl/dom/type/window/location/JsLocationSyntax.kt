package net.asere.kthot.js.dsl.dom.type.window.location

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsLocation].
 */
class JsLocationSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsLocation>(value), JsLocation {
    internal constructor(value: JsElement) : this("$value")
}

fun JsLocation.Companion.syntax(value: String): JsLocation =
    JsLocationSyntax(value)

fun JsLocation.Companion.syntax(value: JsElement): JsLocation =
    JsLocationSyntax(value)