package net.asere.kthot.js.dsl.syntax.operational.access.operation

import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.access.operator.Chain
import net.asere.kthot.js.dsl.syntax.operational.access.operator.ChainingOperator
import net.asere.kthot.js.dsl.syntax.operational.access.operator.OptionalChain
import net.asere.kthot.js.dsl.type.isNullable
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax

class ChainOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : CompoundOperation() {

    constructor(leftHand: Operable, rightHand: String) : this(leftHand, JsObject.syntax(rightHand))

    override val operator: ChainingOperator = if (leftHand.isNullable())
        OptionalChain else Chain

    override val value: String get() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("${leftHand.groupIfGroupable()}")
        stringBuilder.append("$operator")
        stringBuilder.append("$rightHand")
        return stringBuilder.toString()
    }
}