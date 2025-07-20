package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Mod

class ModOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Mod
}

operator fun Operable.rem(rightHand: Operable): ModOperation = ModOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun CompoundOperation.rem(rightHand: Operable): ModOperation = ModOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)