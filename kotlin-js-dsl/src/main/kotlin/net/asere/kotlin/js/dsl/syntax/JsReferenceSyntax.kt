package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

abstract class JsReferenceSyntax<T : JsValue>(
    value: String,
    override val isNullable: Boolean,
) : JsSyntax(value), JsReference<T> {

    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)

    override val name: String get() = value

    override fun toString(): String = present()
}