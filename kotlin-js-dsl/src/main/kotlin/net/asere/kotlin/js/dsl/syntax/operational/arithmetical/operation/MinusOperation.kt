package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Minus

class MinusOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Minus
}

operator fun Operable.minus(rightHand: Operable): MinusOperation = MinusOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun Operation.minus(rightHand: Operable): MinusOperation = MinusOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)