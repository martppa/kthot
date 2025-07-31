package net.asere.kotlin.js.dsl.type.`object`

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

open class JsObjectSyntax internal constructor(value: String) : JsReferenceSyntax<JsObject>(value), JsObject {
    internal constructor(value: JsElement) : this("$value")
}

fun JsObject.Companion.syntax(value: String): JsObjectSyntax = JsObjectSyntax(value)
fun JsObject.Companion.syntax(value: JsElement): JsObjectSyntax = JsObjectSyntax(value)