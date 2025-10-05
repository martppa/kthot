package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.value.JsValue
import net.asere.kthot.js.dsl.type.lambda.JsLambdaValue
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax

class JsLambda4Value<
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue> internal constructor(
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val param4: JsDefinition<Param4Ref, Param4>,
    private val definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref) -> Unit,
) : JsLambdaValue(), JsLambda4<Param1, Param2, Param3, Param4> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference, param2.reference, param3.reference, param4.reference)
        },
        invocationParameters = listOf(param1.reference, param2.reference, param3.reference, param4.reference)
    )

    override operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4) = InvocationOperation(
        JsObject.syntax("($this)"), param1, param2, param3, param4
    )

    companion object
}