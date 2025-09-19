package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.isNullable
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValue
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda0Value<Result : JsValue> @InternalApi constructor(
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