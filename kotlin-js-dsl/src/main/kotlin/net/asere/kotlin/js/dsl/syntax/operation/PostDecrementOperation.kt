package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.operation.operator.Decrement
import net.asere.kotlin.js.dsl.type.number.JsNumber

class PostDecrementOperation(
    number: JsNumber,
) : ReflexiveOperation() {
    override val leftSideElement: JsElement = number
    override val rightSideElement: JsElement = Decrement
}

val JsNumber.`--` get() = postDec()

fun JsNumber.postDec(): PostDecrementOperation = PostDecrementOperation(
    number = this
)