package net.asere.kotlin.js.dsl.types.type.lambda

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

interface JsLambda : JsValue {
    operator fun invoke() = JsSyntax("$this()")

    companion object
}