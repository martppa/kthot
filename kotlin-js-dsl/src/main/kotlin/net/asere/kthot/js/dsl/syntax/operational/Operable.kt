package net.asere.kthot.js.dsl.syntax.operational

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.logical.NegatedOperable

interface Operable : JsElement

operator fun Operable.not(): Operable = if (this is NegatedOperable<*>)
    operable
else
    NegatedOperable(this)