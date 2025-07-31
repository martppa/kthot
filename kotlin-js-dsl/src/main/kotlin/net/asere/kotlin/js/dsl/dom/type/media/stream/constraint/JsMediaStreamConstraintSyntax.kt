package net.asere.kotlin.js.dsl.dom.type.media.stream.constraint

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamConstraintSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMediaStreamConstraint>(value),
    JsMediaStreamConstraint {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaStreamConstraint.Companion.syntax(value: String): JsMediaStreamConstraintSyntax =
    JsMediaStreamConstraintSyntax(value)

fun JsMediaStreamConstraint.Companion.syntax(value: JsElement): JsMediaStreamConstraintSyntax =
    JsMediaStreamConstraintSyntax(value)