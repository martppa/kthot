package net.asere.kotlin.js.dsl.dom.type.document

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsDocument].
 */
class JsDocumentSyntax internal constructor(value: String) : JsSyntax(value), JsDocument {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDocument.Companion.syntax(value: String): JsDocumentSyntax = JsDocumentSyntax(value)
fun JsDocument.Companion.syntax(value: JsElement): JsDocumentSyntax = JsDocumentSyntax(value)