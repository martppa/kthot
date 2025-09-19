package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.syntax.instantiation.Instantiable
import net.asere.kotlin.js.dsl.syntax.instantiation.JsInstantiationSyntax
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.value.JsRawValue

class JsErrorValue internal constructor(
    val value: String
) : JsError, JsRawValue<JsError>, Instantiable {

    override fun present(): String = value

    override fun toString(): String = present()
}

fun JsError.Companion.new(value: String): JsError =
    JsError.syntax(JsInstantiationSyntax(JsErrorValue("Error(${value.js})")))