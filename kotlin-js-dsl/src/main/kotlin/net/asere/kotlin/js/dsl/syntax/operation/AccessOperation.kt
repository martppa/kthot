package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.isNullable
import net.asere.kotlin.js.dsl.syntax.operation.operator.Access
import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator
import net.asere.kotlin.js.dsl.syntax.operation.operator.OptionalAccess
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.obj.syntax
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.string.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class AccessOperation(
    internal val operable: JsValue,
    arg: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, arg: JsValue)
            : this(JsString.syntax(leftSideElement), arg)

    constructor(leftSideElement: JsValue, arg: String)
            : this(leftSideElement, JsString.syntax(arg))

    override val leftSideElement: JsValue = JsObject.syntax(operable)
    override val rightSideElement: Operator = if (leftSideElement.isNullable())
        OptionalAccess(arg) else Access(arg)
}