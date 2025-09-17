package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.obj.JsObjectValue
import net.asere.kotlin.js.dsl.type.value.JsValue

interface JsNothing : JsValue {
    companion object
}

private class JsNothingValue(
    value: JsElement
) : JsObjectValue(value), JsNothing

fun JsNothing.Companion.syntax(value: JsElement, unused: Boolean = false): JsNothing = JsNothingValue(value)