package net.asere.kotlin.js.dsl.types.value.lambda

import net.asere.kotlin.js.dsl.syntax.*

class JsLambdaValue(
    private val definition: JsSyntaxScope.() -> Unit,
) : JsLambdaValueCommons() {
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))

    companion object
}