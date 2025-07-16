package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.type.JsString

class JsStringValue(
    val value: String
) : JsString(), JsRawValue<JsString> {

    override fun present(): String = """
        "$value"
    """.trimIndent()
}

fun JsString.Companion.value(name: String): JsString = JsStringValue(name)