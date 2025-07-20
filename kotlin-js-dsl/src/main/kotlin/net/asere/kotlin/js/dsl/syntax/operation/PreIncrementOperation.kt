package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.reference.JsNumberRef
import net.asere.kotlin.js.dsl.syntax.operation.operator.Increment
import net.asere.kotlin.js.dsl.type.JsNumber

class PreIncrementOperation(
    number: JsNumber,
) : ReflexiveOperation() {
    override val leftSideElement: JsElement = Increment
    override val rightSideElement: JsElement = number
}

fun JsNumber.preInc(): PreIncrementOperation = PreIncrementOperation(
    number = this
)