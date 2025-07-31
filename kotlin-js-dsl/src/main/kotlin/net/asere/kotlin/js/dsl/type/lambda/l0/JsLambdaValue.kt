package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValueCommons

class JsLambdaValue(
    private val definition: JsSyntaxScope.() -> Unit,
) : JsLambdaValueCommons(), JsLambda {
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))

    companion object
}