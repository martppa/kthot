package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.JsElement

interface Operable : JsElement

operator fun Operable.not(): Operable = if (this is NegatedOperable<*>)
    operable
else
    NegatedOperable(this)