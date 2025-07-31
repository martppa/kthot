package net.asere.kotlin.js.dsl.syntax.operation.operator

import net.asere.kotlin.js.dsl.type.value.JsValue

class OptionalInvocation(
    vararg args: JsValue
) : InvocationOperator() {
    override val value: String = "?.(${Invocation(*args)})"
}