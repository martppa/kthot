package net.asere.kotlin.js.dsl.syntax.operational.access.operator

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operator.InvocationOperator
import net.asere.kotlin.js.dsl.type.value.JsValue

class OptionalAccess(
    arg: JsValue
) : InvocationOperator() {
    override val value: String = "?.[${Access(arg)}]"
}