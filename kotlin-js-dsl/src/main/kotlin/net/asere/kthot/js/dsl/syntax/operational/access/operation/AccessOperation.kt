package net.asere.kthot.js.dsl.syntax.operational.access.operation

import net.asere.kthot.js.dsl.syntax.operational.Operator
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.access.operator.Access
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

class AccessOperation(
    internal val operable: JsValue,
    arg: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, arg: JsValue)
            : this(JsString.syntax(leftSideElement), arg)

    constructor(leftSideElement: JsValue, arg: String)
            : this(leftSideElement, JsString.syntax(arg))

    override val leftSideElement: JsValue = JsObject.syntax(operable)
    override val rightSideElement: Operator = Access(arg)
}