package net.asere.kotlin.js.dsl.dom.type.location

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsLocation].
 */
class JsLocationSyntax internal constructor(value: String) : JsSyntax(value), JsLocation {
    internal constructor(value: JsElement) : this("$value")
}

fun JsLocation.Companion.syntax(value: String): JsLocationSyntax = JsLocationSyntax(value)
fun JsLocation.Companion.syntax(value: JsElement): JsLocationSyntax = JsLocationSyntax(value)