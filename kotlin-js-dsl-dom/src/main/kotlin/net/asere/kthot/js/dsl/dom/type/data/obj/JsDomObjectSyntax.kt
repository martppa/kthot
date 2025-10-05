package net.asere.kthot.js.dsl.dom.type.data.obj

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsDomObjectSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsDomObject>(value, isNullable), JsDomObject {
    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDomObject.Companion.syntax(value: String, isNullable: Boolean = false): JsDomObjectSyntax =
    JsDomObjectSyntax(value, isNullable)

fun JsDomObject.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDomObjectSyntax =
    JsDomObjectSyntax(value, isNullable)