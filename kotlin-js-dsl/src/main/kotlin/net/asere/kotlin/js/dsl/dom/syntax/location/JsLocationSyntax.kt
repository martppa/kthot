package net.asere.kotlin.js.dsl.dom.syntax.location

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsLocation
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsLocation].
 */
class JsLocationSyntax(value: String) : JsSyntax(value), JsLocation {
    constructor(value: JsElement) : this("$value")
}