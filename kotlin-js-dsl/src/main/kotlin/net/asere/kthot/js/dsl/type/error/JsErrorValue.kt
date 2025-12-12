package net.asere.kthot.js.dsl.type.error

import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.value.JsRawValue

class JsErrorValue internal constructor(
    val value: String
) : JsError, JsRawValue<JsError> {

    override fun present(): String = value

    override fun toString(): String = present()
}

fun JsError.Companion.new(value: String = ""): JsError =
    JsError.syntax(InstantiationOperation(InvocationOperation("Error", value.js)))

fun JsError.Companion.new(value: JsString = "".js): JsError =
    JsError.syntax(InstantiationOperation(InvocationOperation("Error", value)))