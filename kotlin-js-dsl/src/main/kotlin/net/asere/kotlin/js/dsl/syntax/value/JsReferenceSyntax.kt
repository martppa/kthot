package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

abstract class JsReferenceSyntax<T : JsValue>(value: String) : JsSyntax(value), JsReference<T> {

    constructor(value: JsElement) : this("$value")

    override val name: String get() = value

    override fun toString(): String = present()

    companion object {
        fun <T : JsValue> of(value: String): JsReferenceSyntax<T> = object : JsReferenceSyntax<T>(value) {}
    }
}