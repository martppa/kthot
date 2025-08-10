package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Div

class DivOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Div
}

operator fun Operable.div(rightHand: Operable): DivOperation = DivOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun Operation.div(rightHand: Operable): DivOperation = DivOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)