package net.asere.kotlin.js.dsl.dom.type.location

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.history.JsHistory
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

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