package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.isNullable
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda0Value<Result : JsValue> @JsInternalApi constructor(
    private val resultTypeBuilder: (JsElement, Boolean) -> Result,
    private val definition: JsSyntaxScope.() -> Result,
) : JsLambdaValue(), JsResultLambda0<Result> {

    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply {
        definition()
    })

    override fun invoke(): Result = run {
        val result = JsSyntaxScope().run { definition(this) }
        resultTypeBuilder(this, result.isNullable())
    }

    companion object
}