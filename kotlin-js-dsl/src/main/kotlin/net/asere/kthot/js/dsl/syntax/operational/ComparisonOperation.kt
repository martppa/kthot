package net.asere.kthot.js.dsl.syntax.operational

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.bool.JsBoolean

interface ComparisonOperation : Operation, JsBoolean {
    companion object {
        fun anonymous(element: JsElement) = object : ArithmeticalOperation {
            override fun present(): String = "$element"
            override fun toString(): String = present()
        }
    }
}