package net.asere.kotlin.js.dsl.types.value.lambda

import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda

class JsLambdaValue(
    private val definition: JsSyntaxScope.() -> Unit,
) : JsLambdaValueCommons(), JsLambda {
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))

    companion object
}