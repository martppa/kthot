package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.type.value.JsRawValue

open class JsStringValue(
    val value: String
) : JsString, JsRawValue<JsString> {

    override fun present(): String = "'$value'"

    override fun toString(): String = present()

    override fun stringify(): String = value
}

fun JsString.Companion.value(value: String): JsString = JsStringValue(value)