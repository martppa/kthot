package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement

class JsSyntaxBuilder<T>(val value: T) : JsElement {

    private val stringBuilder = StringBuilder()

    fun append(element: JsElement) {
        stringBuilder.append(element)
    }

    override fun present(): String = stringBuilder.toString()

    override fun toString(): String = present()
}