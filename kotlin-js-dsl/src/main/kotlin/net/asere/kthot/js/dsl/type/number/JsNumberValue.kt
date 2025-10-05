package net.asere.kthot.js.dsl.type.number

class JsNumberValue internal constructor(
    val value: Number
) : JsNumber, net.asere.kthot.js.dsl.type.value.JsRawValue<JsNumber> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsNumber.Companion.value(value: Number): JsNumber = JsNumberValue(value)