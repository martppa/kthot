package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.type.JsNumber

class JsNumberValue internal constructor(
    val value: Number
) : JsNumber(), JsRawValue<JsNumber> {

    override fun present(): String = """
        $value
    """.trimIndent()
}

fun JsNumber.Companion.value(value: Number): JsNumber = JsNumberValue(value)