package net.asere.kotlin.js.dsl.syntax.operation.operator

import net.asere.kotlin.js.dsl.types.value.JsValue

class OptionalAccess(
    arg: JsValue
) : InvocationOperator() {
    override val value: String = "?.[${Access(arg)}]"
}