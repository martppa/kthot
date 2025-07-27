@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.types.type.function

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.ReferenceId
import net.asere.kotlin.js.dsl.types.reference.function.JsFunction2Ref
import net.asere.kotlin.js.dsl.types.value.JsValue

@JsDsl
fun <Param1Ref: JsReference<Param1>, Param1 : JsValue, Param2Ref: JsReference<Param2>, Param2 : JsValue> JsScriptScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsSyntaxScope.(
        Param1, Param2
    ) -> Unit
) = +JsFunction2(
    name = name,
    param1 = param1,
    param2 = param2,
    definition = definition
)

class JsFunction2<Param1Ref: JsReference<Param1>, Param1 : JsValue, Param2Ref: JsReference<Param2>, Param2 : JsValue>(
    name: String,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
    ) -> Unit,
) : JsFunctionCommons<JsFunction2Ref<Param1, Param2>>(name) {

    override val functionRef: JsFunction2Ref<Param1, Param2> = JsFunction2Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference as Param1, param2.reference as Param2)
        },
        invocationParameters = listOf(param1.reference, param2.reference)
    )
}