package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.type.JsArray
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsArraySyntax<T : JsValue>(value: String) : JsReferenceSyntax<JsArray<T>>(value), JsArray<T> {
    constructor(value: JsElement) : this("$value")
}