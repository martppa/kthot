package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda1Value<Param1Ref: JsReference<Param1>, Param1 : JsValue> internal constructor(
    private val param: JsDefinition<Param1Ref, Param1>,
    private val definition: JsSyntaxScope.(Param1Ref) -> Unit,
) : JsLambdaValue(), JsLambda1<Param1> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param.reference)
        },
        invocationParameters = listOf(param.reference)
    )

    override operator fun invoke(param: Param1) = TODO()

    companion object
}