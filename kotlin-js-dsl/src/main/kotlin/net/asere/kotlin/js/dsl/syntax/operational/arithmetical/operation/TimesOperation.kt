package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Times

class TimesOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Times
}

operator fun Operable.times(rightHand: Operable): TimesOperation = TimesOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun CompoundOperation.times(rightHand: Operable): TimesOperation = TimesOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)