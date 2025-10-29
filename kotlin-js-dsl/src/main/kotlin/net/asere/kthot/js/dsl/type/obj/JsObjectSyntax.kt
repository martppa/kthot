package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement

open class JsObjectSyntax internal constructor(value: String) : JsReferenceSyntax<JsObject>(value), JsObject {
    internal constructor(value: JsElement) : this("$value")
}

fun JsObject.Companion.syntax(value: String): JsObject = JsObjectSyntax(value)
fun JsObject.Companion.syntax(value: JsElement): JsObject = JsObjectSyntax(value)