package net.asere.kthot.js.dsl.dom.type.content.media.stream.constraint

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamConstraintSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsMediaStreamConstraint>(value, isNullable),
    JsMediaStreamConstraint {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsMediaStreamConstraint.Companion.syntax(value: String, isNullable: Boolean = false): JsMediaStreamConstraint =
    JsMediaStreamConstraintSyntax(value, isNullable)

fun JsMediaStreamConstraint.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsMediaStreamConstraint =
    JsMediaStreamConstraintSyntax(value, isNullable)