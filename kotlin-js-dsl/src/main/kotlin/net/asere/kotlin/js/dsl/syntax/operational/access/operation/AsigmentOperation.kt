package net.asere.kotlin.js.dsl.syntax.operational.access.operation

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.assignment.operator.Assign
import net.asere.kotlin.js.dsl.syntax.operational.assignment.operator.AssignmentOperator

class AssignmentOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : CompoundOperation() {
    override val operator: AssignmentOperator = Assign
}