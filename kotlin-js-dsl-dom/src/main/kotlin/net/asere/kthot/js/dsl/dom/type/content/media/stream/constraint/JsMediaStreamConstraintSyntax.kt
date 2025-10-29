package net.asere.kthot.js.dsl.dom.type.content.media.stream.constraint

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamConstraintSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMediaStreamConstraint>(value),
    JsMediaStreamConstraint {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaStreamConstraint.Companion.syntax(value: String): JsMediaStreamConstraint =
    JsMediaStreamConstraintSyntax(value)

fun JsMediaStreamConstraint.Companion.syntax(value: JsElement): JsMediaStreamConstraint =
    JsMediaStreamConstraintSyntax(value)