package net.asere.kotlin.js.dsl.types.value.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda3
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda3Value<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> internal constructor(
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>, JsReference<Param3>) -> Unit,
) : JsLambdaValueCommons(), JsLambda3<Param1, Param2, Param3> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3)
        },
        invocationParameters = listOf(param1, param2, param3)
    )

    override operator fun invoke(param1: Param1, param2: Param2, param3: Param3) = JsSyntax("($this)($param1, $param2, $param3)")

    companion object
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> jsLambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>, JsReference<Param3>) -> Unit,
): JsLambda3<Param1, Param2, Param3> = JsLambda3Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    definition = definition
)