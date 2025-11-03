package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement

open class JsSyntax(
    value: String? = null
) : JsElement  {

    constructor(value: JsElement) : this("$value")

    protected open val _value_: String = value.orEmpty()

    override fun present(): String = _value_

    override fun toString(): String = present()

    operator fun plus(syntax: JsSyntax) = JsSyntax("$this $syntax")
}

object JsEmptySyntax : JsSyntax()