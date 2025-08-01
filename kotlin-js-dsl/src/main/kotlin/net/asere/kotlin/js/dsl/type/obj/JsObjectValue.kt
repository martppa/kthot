package net.asere.kotlin.js.dsl.type.obj

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.value.JsRawValue

class JsObjectValue internal constructor(
    val value: JsSyntax
) : JsObject, JsRawValue<JsObject> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsObject.Companion.value(value: String): JsObjectValue = JsObjectValue(JsSyntax(value))