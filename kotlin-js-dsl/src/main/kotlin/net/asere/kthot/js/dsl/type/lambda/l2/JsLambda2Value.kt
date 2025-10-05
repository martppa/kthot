package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.value.JsValue
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax

class JsLambda2Value<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue> internal constructor(
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Unit,
) : JsLambdaValue(), JsLambda2<Param1, Param2> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference, param2.reference)
        },
        invocationParameters = listOf(param1.reference, param2.reference)
    )

    override operator fun invoke(param1: Param1, param2: Param2) = InvocationOperation(
        operable = JsObject.syntax("($this)"), param1, param2
    )

    companion object
}