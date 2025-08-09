package net.asere.kotlin.js.dsl.dom.type.obj

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsDomObjectSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsDomObject>(value, isNullable), JsDomObject {
    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDomObject.Companion.syntax(value: String, isNullable: Boolean = false): JsDomObjectSyntax =
    JsDomObjectSyntax(value, isNullable)

fun JsDomObject.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDomObjectSyntax =
    JsDomObjectSyntax(value, isNullable)