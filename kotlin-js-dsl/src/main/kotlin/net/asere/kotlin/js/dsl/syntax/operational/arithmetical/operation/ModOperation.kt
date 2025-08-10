package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Mod
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison

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