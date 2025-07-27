package net.asere.kotlin.js.dsl.syntax.operation.operator

import net.asere.kotlin.js.dsl.types.value.JsValue

class Invocation(
    vararg args: JsValue
) : InvocationOperator() {
    override val value: String = "(${args.joinToString(", ")})"
}