package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsRawValue

open class JsObjectValue internal constructor(
    val value: JsElement
) : JsObject, JsRawValue<JsObject> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun JsObject.Companion.value(value: String): JsObjectValue = JsObjectValue(JsSyntax(value))