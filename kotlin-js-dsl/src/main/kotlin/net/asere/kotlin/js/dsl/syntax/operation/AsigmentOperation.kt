package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.Assign
import net.asere.kotlin.js.dsl.syntax.operation.operator.AssignmentOperator

class AssignmentOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : CompoundOperation() {
    override val operator: AssignmentOperator = Assign
}