package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.JsLambda2

class JsLambda2Value<Param1 : JsValue, Param2 : JsValue> internal constructor(
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>) -> Unit,
) : JsLambdaValueCommons(), JsLambda2<Param1, Param2> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2)
        },
        invocationParameters = listOf(param1, param2)
    )

    override operator fun invoke(param1: Param1, param2: Param2) = JsSyntax("($this)($param1, $param2)")

    companion object
}

fun <Param1 : JsValue, Param2 : JsValue> jsLambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>) -> Unit,
): JsLambda2<Param1, Param2> = JsLambda2Value(
    param1 = param1,
    param2 = param2,
    definition = definition
)