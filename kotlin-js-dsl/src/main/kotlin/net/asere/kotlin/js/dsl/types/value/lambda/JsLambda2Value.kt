package net.asere.kotlin.js.dsl.types.value.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda2
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda2Value<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue> internal constructor(
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Unit,
) : JsLambdaValueCommons(), JsLambda2<Param1, Param2> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference, param2.reference)
        },
        invocationParameters = listOf(param1.reference, param2.reference)
    )

    override operator fun invoke(param1: Param1, param2: Param2) = JsSyntax("($this)($param1, $param2)")

    companion object
}

fun <Param1Ref: JsReference<Param1>, Param1 : JsValue, Param2Ref: JsReference<Param2>, Param2 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Unit,
): JsLambda2<Param1, Param2> = JsLambda2Value(
    param1 = param1,
    param2 = param2,
    definition = definition
)