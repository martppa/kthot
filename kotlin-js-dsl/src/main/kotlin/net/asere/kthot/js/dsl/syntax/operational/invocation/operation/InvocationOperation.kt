package net.asere.kthot.js.dsl.syntax.operational.invocation.operation

import net.asere.kthot.js.dsl.syntax.operational.Operator
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operator.Invocation
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

class InvocationOperation(
    internal val operable: JsValue,
    vararg args: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, vararg args: JsValue)
            : this(JsObject.syntax(leftSideElement), *args)

    override val leftSideElement: JsValue = JsObject.syntax(operable)
    override val rightSideElement: Operator = Invocation(*args)
}