package net.asere.kotlin.js.dsl.syntax.operational

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.operational.logical.NegatedOperable

interface Operable : JsElement

operator fun Operable.not(): Operable = if (this is NegatedOperable<*>)
    operable
else
    NegatedOperable(this)