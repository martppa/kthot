package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

abstract class JsReferenceSyntax<T : JsValue>(
    value: String,
) : JsSyntax(value), JsReference<T> {

    constructor(value: JsElement) : this("$value")

    override val refName: String get() = value

    override fun toString(): String = present()
}