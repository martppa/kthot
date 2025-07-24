package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.types.type.JsNumber

class JsNumberValue internal constructor(
    val value: Number
) : JsNumber, JsRawValue<JsNumber> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsNumber.Companion.value(value: Number): JsNumber = JsNumberValue(value)