package net.asere.kotlin.js.dsl.dom.type.content.document

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

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