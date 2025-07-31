package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.value.JsRawValue

class JsErrorValue internal constructor(
    val value: JsSyntax
) : JsError, JsRawValue<JsError> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsError.Companion.value(value: String): JsErrorValue = JsErrorValue(
    JsSyntax("Error(${value.js})")
)