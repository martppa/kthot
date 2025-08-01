package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.isNullable
import net.asere.kotlin.js.dsl.syntax.operation.operator.Invocation
import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator
import net.asere.kotlin.js.dsl.syntax.operation.operator.OptionalInvocation
import net.asere.kotlin.js.dsl.type.obj.JsObjectSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class InvocationOperation(
    internal val operable: JsValue,
    vararg args: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, vararg args: JsValue)
            : this(JsObjectSyntax(leftSideElement), *args)

    override val leftSideElement: JsValue = JsObjectSyntax(operable)
    override val rightSideElement: Operator = if (leftSideElement.isNullable())
        OptionalInvocation(*args) else Invocation(*args)
}