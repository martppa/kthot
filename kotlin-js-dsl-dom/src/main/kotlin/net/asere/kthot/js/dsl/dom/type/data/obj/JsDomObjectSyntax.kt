package net.asere.kthot.js.dsl.dom.type.data.obj

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsDomObjectSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDomObject>(value), JsDomObject {
    constructor(value: JsElement) : this("$value")
}

fun JsDomObject.Companion.syntax(value: String): JsDomObjectSyntax =
    JsDomObjectSyntax(value)

fun JsDomObject.Companion.syntax(value: JsElement): JsDomObjectSyntax =
    JsDomObjectSyntax(value)