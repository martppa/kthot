package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Increment
import net.asere.kotlin.js.dsl.type.number.JsNumber

class PreIncrementOperation(
    number: JsNumber,
) : ReflexiveOperation() {
    override val leftSideElement: JsElement = Increment
    override val rightSideElement: JsElement = number
}

fun JsNumber.preInc(): PreIncrementOperation = PreIncrementOperation(
    number = this
)