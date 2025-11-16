package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

open class JsObjectSyntax internal constructor(value: String) : JsReferenceSyntax<JsObject>(value), JsObject {
    internal constructor(value: JsElement) : this("$value")
}

fun JsObject.Companion.syntax(value: String): JsObject = JsObjectSyntax(value)
fun JsObject.Companion.syntax(value: JsElement): JsObject = JsObjectSyntax(value)
fun JsObject.Companion.syntax(block: JsScope.() -> JsObject): JsObject {
    val scope = JsSyntaxScope()
    scope.block()
    return syntax(scope)
}