package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.isNullable
import net.asere.kotlin.js.dsl.syntax.operation.operator.*
import net.asere.kotlin.js.dsl.syntax.value.JsObjectSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

class AccessOperation(
    internal val operable: JsValue,
    arg: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, arg: JsValue)
            : this(JsObjectSyntax(leftSideElement), arg)

    override val leftSideElement: JsValue = JsObjectSyntax(operable)
    override val rightSideElement: Operator = if (leftSideElement.isNullable())
        OptionalAccess(arg) else Access(arg)
}