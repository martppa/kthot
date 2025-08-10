package net.asere.kotlin.js.dsl.syntax.operational.invocation.operation

import net.asere.kotlin.js.dsl.isNullable
import net.asere.kotlin.js.dsl.syntax.operational.Operator
import net.asere.kotlin.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operator.Invocation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operator.OptionalInvocation
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.obj.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class InvocationOperation(
    internal val operable: JsValue,
    vararg args: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, vararg args: JsValue)
            : this(JsObject.Companion.syntax(leftSideElement), *args)

    override val leftSideElement: JsValue = JsObject.Companion.syntax(operable)
    override val rightSideElement: Operator = if (leftSideElement.isNullable())
        OptionalInvocation(*args) else Invocation(*args)
}