package net.asere.kthot.js.dsl.dom.type.structure.form

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsForm].
 */
class JsFormSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsForm>(value), JsForm {
    internal constructor(value: JsElement) : this("$value")
}

fun JsForm.Companion.syntax(value: String): JsForm =
    JsFormSyntax(value)

fun JsForm.Companion.syntax(value: JsElement): JsForm =
    JsFormSyntax(value)