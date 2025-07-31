package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.type.value.JsRawValue

class JsStringValue(
    val value: String
) : JsString, JsRawValue<JsString> {

    override fun present(): String = "'$value'"

    override fun toString(): String = present()
}

fun JsString.Companion.value(value: String): JsString = JsStringValue(value)