package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Plus
import net.asere.kotlin.js.dsl.type.number.JsNumber

class PlusOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation(), JsNumber { // TODO: Create a concat operation
    override val operator: ArithmeticalOperator = Plus
}

operator fun Operable.plus(rightHand: Operable): PlusOperation = PlusOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun CompoundOperation.plus(rightHand: Operable): PlusOperation = PlusOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)