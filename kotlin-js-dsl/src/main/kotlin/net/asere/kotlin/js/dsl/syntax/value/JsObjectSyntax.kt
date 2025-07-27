package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.type.JsObject

open class JsObjectSyntax(value: String) : JsReferenceSyntax<JsObject>(value), JsObject {
    constructor(value: JsElement) : this("$value")
}