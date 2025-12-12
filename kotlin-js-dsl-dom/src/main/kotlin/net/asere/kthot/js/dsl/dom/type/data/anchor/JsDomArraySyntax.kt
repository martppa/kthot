package net.asere.kthot.js.dsl.dom.type.data.anchor

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsAnchorSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsAnchor>(value), JsAnchor {
    internal constructor(value: JsElement) : this("$value")
}

fun JsAnchor.Companion.syntax(value: String): JsAnchor =
    JsAnchorSyntax(value)

fun JsAnchor.Companion.syntax(value: JsElement): JsAnchor =
    JsAnchorSyntax(value)