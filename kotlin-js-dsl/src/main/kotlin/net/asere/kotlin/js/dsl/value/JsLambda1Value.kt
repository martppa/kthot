package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.JsLambda1

class JsLambda1Value<Param1 : JsValue> internal constructor(
    private val param: JsReference<Param1>,
    private val definition: JsSyntaxScope.(JsReference<Param1>) -> Unit,
) : JsLambdaValueCommons(), JsLambda1<Param1> {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param)
        },
        invocationParameters = listOf(param)
    )

    override operator fun invoke(param: Param1) = JsSyntax("($this)($param)")

    companion object
}

fun <Param1 : JsValue> jsLambda(
    param: JsReference<Param1>,
    definition: JsSyntaxScope.(JsReference<Param1>) -> Unit,
): JsLambda1<Param1> = JsLambda1Value(
    param = param,
    definition = definition
)