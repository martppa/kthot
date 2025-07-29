package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsDocument
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsDocument].
 */
class JsDocumentSyntax(value: String) : JsSyntax(value), JsDocument {
    constructor(value: JsElement) : this("$value")
}