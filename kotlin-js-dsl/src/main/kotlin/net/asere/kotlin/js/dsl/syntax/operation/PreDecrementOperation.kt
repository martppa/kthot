package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.operation.operator.Decrement
import net.asere.kotlin.js.dsl.type.number.JsNumber

class PreDecrementOperation(
    number: JsNumber,
) : ReflexiveOperation() {
    override val leftSideElement: JsElement = Decrement
    override val rightSideElement: JsElement = number
}

fun JsNumber.preDec(): PreIncrementOperation = PreIncrementOperation(
    number = this
)