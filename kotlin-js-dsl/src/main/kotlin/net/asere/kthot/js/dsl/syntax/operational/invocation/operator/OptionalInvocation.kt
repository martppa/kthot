package net.asere.kthot.js.dsl.syntax.operational.invocation.operator

import net.asere.kthot.js.dsl.type.value.JsValue

class OptionalInvocation(
    vararg args: JsValue
) : InvocationOperator() {
    override val value: String = "?.(${Invocation(*args)})"
}