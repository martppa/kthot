package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

open class JsObjectSyntax internal constructor(value: String, isNullable: Boolean) : JsReferenceSyntax<JsObject>(value, isNullable), JsObject {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsObject.Companion.syntax(value: String, isNullable: Boolean = false): JsObject = JsObjectSyntax(value, isNullable)
fun JsObject.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsObject = JsObjectSyntax(value,isNullable)