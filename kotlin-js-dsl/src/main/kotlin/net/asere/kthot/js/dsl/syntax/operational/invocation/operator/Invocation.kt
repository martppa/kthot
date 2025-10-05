package net.asere.kthot.js.dsl.syntax.operational.invocation.operator

import net.asere.kthot.js.dsl.type.value.JsValue

class Invocation(
    vararg args: JsValue
) : InvocationOperator() {
    override val value: String = "(${args.joinToString(", ")})"
}