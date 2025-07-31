package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.GreaterEqualsThan
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax

class GreaterEqualsThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = GreaterEqualsThan
}

infix fun Operable.gte(rightHand: Operable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.gte(rightHand: Operable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)

infix fun Operable.gte(rightHand: Number): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = JsNumberSyntax("$rightHand")
)

infix fun Operation.gte(rightHand: Number): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = JsNumberSyntax("$rightHand")
)