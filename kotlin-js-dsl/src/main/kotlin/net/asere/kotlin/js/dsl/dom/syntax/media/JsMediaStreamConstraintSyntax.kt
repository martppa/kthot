package net.asere.kotlin.js.dsl.dom.syntax.media

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.media.JsMediaStreamConstraint
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax

class JsMediaStreamConstraintSyntax(value: String) : JsReferenceSyntax<JsMediaStreamConstraint>(value),
    JsMediaStreamConstraint {
    constructor(value: JsElement) : this("$value")
}