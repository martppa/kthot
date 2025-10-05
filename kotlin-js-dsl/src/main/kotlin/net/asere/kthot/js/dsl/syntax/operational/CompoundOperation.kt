package net.asere.kthot.js.dsl.syntax.operational

import net.asere.kthot.js.dsl.syntax.operational.logical.operation.NegatedOperation

abstract class CompoundOperation : Operation() {

    internal abstract val leftHand: Operable
    internal abstract val rightHand: Operable
    internal abstract val operator: Operator

    override val value: String get() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$leftHand")
        stringBuilder.append("$operator")
        stringBuilder.append("$rightHand")
        return stringBuilder.toString()
    }
}

operator fun Operation.not(): Operation = if (this is NegatedOperation<*>)
    comparison
else
    NegatedOperation(this)