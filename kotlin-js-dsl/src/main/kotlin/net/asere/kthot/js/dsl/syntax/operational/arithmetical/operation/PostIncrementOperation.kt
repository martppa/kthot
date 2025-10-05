package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.operator.Increment
import net.asere.kthot.js.dsl.type.number.JsNumber

class PostIncrementOperation(
    number: JsNumber,
) : ReflexiveOperation(), JsNumber {
    override val leftSideElement: JsElement = number
    override val rightSideElement: JsElement = Increment
}

fun JsNumber.postInc(): PostIncrementOperation = PostIncrementOperation(
    number = this
)