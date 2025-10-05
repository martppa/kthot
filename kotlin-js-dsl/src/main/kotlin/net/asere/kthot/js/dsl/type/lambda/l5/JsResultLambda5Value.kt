package net.asere.kthot.js.dsl.type.lambda.l5

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.isNullable
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda5Value<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue,
        Param4Ref: JsReference<Param4>, Param4 : JsValue,
        Param5Ref: JsReference<Param5>, Param5 : JsValue,
        Result : JsValue> @JsInternalApi constructor(
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val param4: JsDefinition<Param4Ref, Param4>,
    private val param5: JsDefinition<Param5Ref, Param5>,
    private val resultTypeBuilder: (JsElement, Boolean) -> Result,
    private val definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref, Param5Ref) -> Result,
) : JsLambdaValue(), JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference, param2.reference, param3.reference, param4.reference, param5.reference)
        },
        invocationParameters = listOf(param1.reference, param2.reference, param3.reference, param4.reference, param5.reference)
    )

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4, param5: Param5): Result = run {
        val result = JsSyntaxScope().run {
            definition(
                this,
                this@JsResultLambda5Value.param1.reference,
                this@JsResultLambda5Value.param2.reference,
                this@JsResultLambda5Value.param3.reference,
                this@JsResultLambda5Value.param4.reference,
                this@JsResultLambda5Value.param5.reference
            )
        }
        resultTypeBuilder(this, result.isNullable())
    }
}