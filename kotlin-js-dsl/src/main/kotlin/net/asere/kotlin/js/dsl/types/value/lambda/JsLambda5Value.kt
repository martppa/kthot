package net.asere.kotlin.js.dsl.types.value.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda5
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda5Value<
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue> internal constructor(
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val param4: JsReference<Param4>,
    private val param5: JsReference<Param5>,
    private val definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>, JsReference<Param3>, JsReference<Param4>, JsReference<Param5>) -> Unit,
) : JsLambdaValueCommons(), JsLambda5<Param1, Param2, Param3, Param4, Param5> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3, param4, param5)
        },
        invocationParameters = listOf(param1, param2, param3, param4, param5)
    )

    override operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4, param5: Param5) = JsSyntax("($this)($param1, $param2, $param3, $param4, $param5)")

    companion object
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> jsLambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    param4: JsReference<Param4>,
    param5: JsReference<Param5>,
    definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>, JsReference<Param3>, JsReference<Param4>, JsReference<Param5>) -> Unit,
): JsLambda5<Param1, Param2, Param3, Param4, Param5> = JsLambda5Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    param5 = param5,
    definition = definition
)