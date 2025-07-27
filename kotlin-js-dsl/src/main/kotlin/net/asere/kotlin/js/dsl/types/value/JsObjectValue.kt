package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.types.type.JsError
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.js

class JsObjectValue internal constructor(
    val value: JsSyntax
) : JsObject, JsRawValue<JsError> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsObject.Companion.value(value: String): JsObjectValue = JsObjectValue(
    JsSyntax("Error(${value.js})")
)