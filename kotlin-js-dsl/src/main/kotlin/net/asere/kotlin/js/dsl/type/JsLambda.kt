package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsValue

interface JsLambda : JsValue {
    operator fun invoke() = JsSyntax("$this()")

    companion object
}