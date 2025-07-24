package net.asere.kotlin.js.dsl.types.type.function

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.function.JsFunction4Ref
import net.asere.kotlin.js.dsl.types.value.JsValue

@JsDsl
fun <
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue,
        Param4Ref: JsReference<Param4>, Param4 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4
    ) -> Unit
) = +JsFunction4(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    definition = definition
)

class JsFunction4<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue,
        Param4Ref: JsReference<Param4>, Param4 : JsValue>(
    name: String,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val param4: JsDefinition<Param4Ref, Param4>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4
    ) -> Unit,
) : JsFunctionCommons<JsFunction4Ref<Param1, Param2, Param3, Param4>>(name) {

    override val functionRef: JsFunction4Ref<Param1, Param2, Param3, Param4> = JsFunction4Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference as Param1, param2.reference as Param2, param3.reference as Param3, param4.reference as Param4)
        },
        invocationParameters = listOf(param1.reference, param2.reference, param3.reference, param4.reference)
    )
}