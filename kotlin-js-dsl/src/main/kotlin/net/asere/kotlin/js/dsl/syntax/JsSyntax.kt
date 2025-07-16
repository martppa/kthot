package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement

open class JsSyntax(
    private val value: String
) : JsElement {

    override fun present(): String = value

    override fun toString(): String = present()

    operator fun plus(rightHand: JsElement) = JsSyntax("$this $rightHand")

    companion object {
        fun empty() = JsSyntax("")
    }
}