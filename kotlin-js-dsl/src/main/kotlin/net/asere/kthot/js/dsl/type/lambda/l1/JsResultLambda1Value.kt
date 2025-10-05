package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.isNullable
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda1Value<Param1Ref: JsReference<Param1>, Param1 : JsValue, Result : JsValue> @JsInternalApi constructor(
    private val param: JsDefinition<Param1Ref, Param1>,
    private val resultTypeBuilder: (JsElement, Boolean) -> Result,
    private val definition: JsSyntaxScope.(Param1Ref) -> Result,
) : JsLambdaValue(), JsResultLambda1<Param1, Result> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param.reference)
        },
        invocationParameters = listOf(param.reference)
    )

    override fun invoke(param: Param1): Result = run {
        val result = JsSyntaxScope().run { definition(this, this@JsResultLambda1Value.param.reference) }
        resultTypeBuilder(this, result.isNullable())
    }

    companion object
}