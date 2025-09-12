package net.asere.kotlin.js.dsl.type.lambda.l3

import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValue
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.obj.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda3Value<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue> internal constructor(
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref) -> Unit,
) : JsLambdaValue(), JsLambda3<Param1, Param2, Param3> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference, param2.reference, param3.reference)
        },
        invocationParameters = listOf(param1.reference, param2.reference, param3.reference)
    )

    override operator fun invoke(param1: Param1, param2: Param2, param3: Param3) = InvocationOperation(
        JsObject.syntax("($this)"), param1, param2, param3
    )

    companion object
}