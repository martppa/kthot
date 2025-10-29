package net.asere.kthot.js.dsl.dom.type.content.document

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsDocument].
 */
class JsDocumentSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDocument>(value), JsDocument {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDocument.Companion.syntax(value: String): JsDocument =
    JsDocumentSyntax(value)

fun JsDocument.Companion.syntax(value: JsElement): JsDocument =
    JsDocumentSyntax(value)