package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.types.type.JsError
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.type.js

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