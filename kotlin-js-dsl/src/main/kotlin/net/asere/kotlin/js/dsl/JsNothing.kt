package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.Undefined
import net.asere.kotlin.js.dsl.type.value.JsValue

interface JsNothing : JsValue {
    companion object
}

fun JsNothing.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsNothing = Undefined