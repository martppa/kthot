package net.asere.kotlin.js.dsl.types.type.function

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.function.JsFunction1Ref
import net.asere.kotlin.js.dsl.types.value.JsValue

@JsDsl
fun <Param1Ref: JsReference<Param1>, Param1 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    definition: JsSyntaxScope.(
        Param1
    ) -> Unit
) = +JsFunction1(
    name = name,
    param1 = param1,
    definition = definition
)

class JsFunction1<Param1Ref: JsReference<Param1>, Param1 : JsValue>(
    name: String,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val definition: JsSyntaxScope.(
        Param1,
    ) -> Unit,
) : JsFunctionCommons<JsFunction1Ref<Param1>>(name) {

    override val functionRef: JsFunction1Ref<Param1> = JsFunction1Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference as Param1)
        },
        invocationParameters = listOf(param1.reference)
    )
}