package net.asere.kotlin.js.dsl.type.bool

import net.asere.kotlin.js.dsl.type.value.JsRawValue

class JsBooleanValue internal constructor(
    val value: Boolean
) : JsBoolean, JsRawValue<JsBoolean> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsBoolean.Companion.value(value: Boolean) = JsBooleanValue(value)