package net.asere.kotlin.js.dsl.type.obj

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

open class JsObjectSyntax internal constructor(value: String, isNullable: Boolean) : JsReferenceSyntax<JsObject>(value, isNullable), JsObject {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsObject.Companion.syntax(value: String, isNullable: Boolean = false): JsObjectSyntax = JsObjectSyntax(value, isNullable)
fun JsObject.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsObjectSyntax = JsObjectSyntax(value,isNullable)