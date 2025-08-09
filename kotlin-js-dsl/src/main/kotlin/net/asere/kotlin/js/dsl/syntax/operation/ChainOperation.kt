package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.isNullable
import net.asere.kotlin.js.dsl.syntax.operation.operator.Chain
import net.asere.kotlin.js.dsl.syntax.operation.operator.ChainingOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.OptionalChain
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.obj.JsObjectSyntax
import net.asere.kotlin.js.dsl.type.obj.syntax

class ChainOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : CompoundOperation() {

    constructor(leftHand: Operable, rightHand: String) : this(leftHand, JsObject.syntax(rightHand))

    override val operator: ChainingOperator = if (leftHand.isNullable())
        OptionalChain else Chain

    override val value: String get() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$leftHand")
        stringBuilder.append("$operator")
        stringBuilder.append("$rightHand")
        return stringBuilder.toString()
    }
}