package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement

open class JsSyntaxBuilder<T>(
    val innerObject: T,
) : JsElement {

    private val stringBuilder = StringBuilder()

    fun append(element: JsElement) {
        stringBuilder.append(element)
    }

    override fun present(): String = stringBuilder.toString()

    override fun toString(): String = present()

    fun forceSingleLine() {
        stringBuilder.replace(0, stringBuilder.length, stringBuilder.toString().replace("\n", ""))
    }
}