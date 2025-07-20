package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator

abstract class CompoundOperation : Operation() {

    internal abstract val leftHand: Operable
    internal abstract val rightHand: Operable
    internal abstract val operator: Operator

    override val value: String get() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$leftHand")
        stringBuilder.append(" $operator ")
        stringBuilder.append("$rightHand")
        return stringBuilder.toString()
    }
}

operator fun Operation.not(): Operation = if (this is NegatedOperation<*>)
    comparison
else
    NegatedOperation(this)