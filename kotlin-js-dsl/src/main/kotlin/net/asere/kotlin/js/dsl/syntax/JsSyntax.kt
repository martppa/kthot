package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement

open class JsSyntax(
    value: String? = null
) : JsElement {

    protected open val value: String = value.orEmpty()

    override fun present(): String = value

    override fun toString(): String = present()

    operator fun plus(syntax: JsSyntax) = JsSyntax("$this $syntax")
}