package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.operator.Decrement
import net.asere.kthot.js.dsl.type.number.JsNumber

class PreDecrementOperation(
    number: JsNumber,
) : ReflexiveOperation(), JsNumber {
    override val leftSideElement: JsElement = Decrement
    override val rightSideElement: JsElement = number
}

fun JsNumber.preDec(): PreIncrementOperation = PreIncrementOperation(
    number = this
)