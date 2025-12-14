package net.asere.kthot.js.dsl.dom.type.html.collection

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsHtmlCollectionSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsHtmlCollection>(value), JsHtmlCollection {
    internal constructor(value: JsElement) : this("$value")
}

fun JsHtmlCollection.Companion.syntax(value: String): JsHtmlCollection =
    JsHtmlCollectionSyntax(value)

fun JsHtmlCollection.Companion.syntax(value: JsElement): JsHtmlCollection =
    JsHtmlCollectionSyntax(value)

fun JsHtmlCollection.Companion.syntax(block: JsScope.() -> JsHtmlCollection): JsHtmlCollection {
    val scope = JsSyntaxScope()
    val collection = scope.block()
    return collection
}