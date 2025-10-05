package net.asere.kthot.js.dsl.syntax.operational.access.operator

import net.asere.kthot.js.dsl.syntax.operational.invocation.operator.InvocationOperator
import net.asere.kthot.js.dsl.type.value.JsValue

class Access(
    arg: JsValue
) : InvocationOperator() {
    override val value: String = "[$arg]"
}