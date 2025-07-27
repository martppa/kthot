package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsArithmeticalSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.syntax.operation.operator.Chain
import net.asere.kotlin.js.dsl.syntax.operation.operator.ChainingOperator
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsString

interface JsValue : JsElement, Operable {
    val chainOperator: ChainingOperator get() = Chain
}

fun JsValue.raw(syntax: JsSyntax) = JsSyntax(ChainOperation(this, "$syntax"))
fun JsValue.raw(syntax: String) = JsSyntax(ChainOperation(this, syntax))
operator fun JsValue.get(value: JsNumber) = JsArithmeticalSyntax("$this[$value]")
operator fun JsValue.get(value: JsString) = JsArithmeticalSyntax("$this[$value]")
operator fun JsValue.get(value: JsValue) = JsArithmeticalSyntax("$this[$value]")