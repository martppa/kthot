package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Increment
import net.asere.kotlin.js.dsl.type.number.JsNumber

class PostIncrementOperation(
    number: JsNumber,
) : ReflexiveOperation() {
    override val leftSideElement: JsElement = number
    override val rightSideElement: JsElement = Increment
}

fun JsNumber.postInc(): PostIncrementOperation = PostIncrementOperation(
    number = this
)