package net.asere.kotlin.js.dsl.dom.type.structure.form

import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsForm].
 */
class JsFormSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsForm>(value, isNullable), JsForm {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsForm.Companion.syntax(value: String, isNullable: Boolean = false): JsForm =
    JsFormSyntax(value, isNullable)

fun JsForm.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsForm =
    JsFormSyntax(value, isNullable)