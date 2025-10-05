package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.operator.Decrement
import net.asere.kthot.js.dsl.type.number.JsNumber

class PostDecrementOperation(
    number: JsNumber,
) : ReflexiveOperation(), JsNumber {
    override val leftSideElement: JsElement = number
    override val rightSideElement: JsElement = Decrement
}

fun JsNumber.postDec(): PostDecrementOperation = PostDecrementOperation(
    number = this
)