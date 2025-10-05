package net.asere.kthot.js.dsl.dom.type.content.document

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsDocument].
 */
class JsDocumentSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsDocument>(value, isNullable), JsDocument {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDocument.Companion.syntax(value: String, isNullable: Boolean = false): JsDocument =
    JsDocumentSyntax(value, isNullable)

fun JsDocument.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDocument =
    JsDocumentSyntax(value, isNullable)