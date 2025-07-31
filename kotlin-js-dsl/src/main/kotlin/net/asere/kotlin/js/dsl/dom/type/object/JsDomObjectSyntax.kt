package net.asere.kotlin.js.dsl.dom.type.`object`

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsDomObjectSyntax internal constructor(value: String) : JsReferenceSyntax<JsDomObject>(value), JsDomObject {
    constructor(value: JsElement) : this("$value")
}

fun JsDomObject.Companion.syntax(value: String): JsDomObjectSyntax = JsDomObjectSyntax(value)
fun JsDomObject.Companion.syntax(value: JsElement): JsDomObjectSyntax = JsDomObjectSyntax(value)