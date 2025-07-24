package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.types.type.JsBoolean

class JsBooleanValue(
    val value: Boolean
) : JsBoolean, JsRawValue<JsBoolean> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsBoolean.Companion.value(value: Boolean) = JsBooleanValue(value)