package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValueCommons

class JsLambda0Value(
    private val definition: JsSyntaxScope.() -> Unit,
) : JsLambdaValueCommons(), JsLambda0 {
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))

    override fun invoke(): InvocationOperation = InvocationOperation("($this)")

    companion object
}