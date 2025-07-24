package net.asere.kotlin.js.dsl.types.value.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda1Value<Param1Ref: JsReference<Param1>, Param1 : JsValue> internal constructor(
    private val param: JsDefinition<Param1Ref, Param1>,
    private val definition: JsSyntaxScope.(Param1Ref) -> Unit,
) : JsLambdaValueCommons(), JsLambda1<Param1> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param.reference)
        },
        invocationParameters = listOf(param.reference)
    )

    override operator fun invoke(param: Param1) = JsSyntax("($this)($param)")

    companion object
}

fun <Param1Ref: JsReference<Param1>, Param1 : JsValue> jsLambda(
    param: JsDefinition<Param1Ref, Param1>,
    definition: JsSyntaxScope.(Param1Ref) -> Unit,
): JsLambda1<Param1> = JsLambda1Value(
    param = param,
    definition = definition
)