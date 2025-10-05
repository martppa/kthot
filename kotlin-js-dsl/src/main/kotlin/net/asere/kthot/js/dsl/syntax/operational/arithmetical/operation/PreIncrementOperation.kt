package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.operator.Increment
import net.asere.kthot.js.dsl.type.number.JsNumber

class PreIncrementOperation(
    number: JsNumber,
) : ReflexiveOperation(), JsNumber {
    override val leftSideElement: JsElement = Increment
    override val rightSideElement: JsElement = number
}

fun JsNumber.preInc(): PreIncrementOperation = PreIncrementOperation(
    number = this
)