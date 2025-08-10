package net.asere.kotlin.js.dsl.syntax.operational.invocation.operator

import net.asere.kotlin.js.dsl.type.value.JsValue

class Invocation(
    vararg args: JsValue
) : InvocationOperator() {
    override val value: String = "(${args.joinToString(", ")})"
}