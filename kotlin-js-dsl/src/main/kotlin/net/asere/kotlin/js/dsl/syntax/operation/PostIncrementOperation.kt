package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.operation.operator.Increment
import net.asere.kotlin.js.dsl.type.number.JsNumber

class PostIncrementOperation(
    number: JsNumber,
) : ReflexiveOperation() {
    override val leftSideElement: JsElement = number
    override val rightSideElement: JsElement = Increment
}

val JsNumber.`++` get() = postInc()

fun JsNumber.postInc(): PostIncrementOperation = PostIncrementOperation(
    number = this
)