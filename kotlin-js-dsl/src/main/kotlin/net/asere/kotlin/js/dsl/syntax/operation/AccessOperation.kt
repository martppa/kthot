package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.isNullable
import net.asere.kotlin.js.dsl.syntax.operation.operator.*
import net.asere.kotlin.js.dsl.type.obj.JsObjectSyntax
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.string.JsStringValue
import net.asere.kotlin.js.dsl.type.value.JsValue

class AccessOperation(
    internal val operable: JsValue,
    arg: JsValue,
) : ReflexiveOperation() {

    constructor(leftSideElement: String, arg: JsValue)
            : this(JsStringSyntax(leftSideElement), arg)

    constructor(leftSideElement: JsValue, arg: String)
            : this(leftSideElement, JsStringSyntax(arg))

    override val leftSideElement: JsValue = JsObjectSyntax(operable)
    override val rightSideElement: Operator = if (leftSideElement.isNullable())
        OptionalAccess(arg) else Access(arg)
}