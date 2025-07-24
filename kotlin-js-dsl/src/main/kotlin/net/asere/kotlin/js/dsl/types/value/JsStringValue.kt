package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.types.type.JsString

class JsStringValue(
    val value: String
) : JsString, JsRawValue<JsString> {

    override fun present(): String = "'$value'"

    override fun toString(): String = present()
}

fun JsString.Companion.value(value: String): JsString = JsStringValue(value)