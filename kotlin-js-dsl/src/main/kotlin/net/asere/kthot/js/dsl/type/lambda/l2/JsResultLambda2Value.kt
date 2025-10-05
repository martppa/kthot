package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.isNullable
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda2Value<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Result : JsValue> @JsInternalApi constructor(
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val resultTypeBuilder: (JsElement, Boolean) -> Result,
    private val definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Result,
) : JsLambdaValue(), JsResultLambda2<Param1, Param2, Result> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference, param2.reference)
        },
        invocationParameters = listOf(param1.reference, param2.reference)
    )

    override fun invoke(param1: Param1, param2: Param2): Result = run {
        val result = JsSyntaxScope().run { definition(this, this@JsResultLambda2Value.param1.reference, this@JsResultLambda2Value.param2.reference) }
        resultTypeBuilder(this, result.isNullable())
    }
}