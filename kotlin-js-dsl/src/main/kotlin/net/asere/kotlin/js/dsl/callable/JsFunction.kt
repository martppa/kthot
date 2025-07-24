@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.callable

import net.asere.kotlin.js.dsl.extension.unaryPlus
import net.asere.kotlin.js.dsl.reference.*
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.reference.*
import net.asere.kotlin.js.dsl.types.value.JsValue

@JsDsl
fun <Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    param4: JsReference<Param4>,
    param5: JsReference<Param5>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4,
        Param5
    ) -> Unit
) = +JsFunction5(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    param5 = param5,
    definition = definition
)

class JsFunction5<
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue>(
    name: String,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val param4: JsReference<Param4>,
    private val param5: JsReference<Param5>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4,
        Param5
    ) -> Unit,
) : JsFunctionCommons<JsFunction5Ref<Param1, Param2, Param3, Param4, Param5>>(name) {

    override val functionRef: JsFunction5Ref<Param1, Param2, Param3, Param4, Param5> = JsFunction5Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1 as Param1, param2 as Param2, param3 as Param3, param4 as Param4, param5 as Param5)
        },
        invocationParameters = listOf(param1, param2, param3, param4, param5)
    )

}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    param4: JsReference<Param4>,
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

class JsFunction4<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val param4: JsReference<Param4>,
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
            definition(this, param1 as Param1, param2 as Param2, param3 as Param3, param4 as Param4)
        },
        invocationParameters = listOf(param1, param2, param3, param4)
    )
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3
    ) -> Unit
) = +JsFunction3(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    definition = definition
)

class JsFunction3<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3
    ) -> Unit,
) : JsFunctionCommons<JsFunction3Ref<Param1, Param2, Param3>>(name) {

    override val functionRef: JsFunction3Ref<Param1, Param2, Param3> = JsFunction3Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1 as Param1, param2 as Param2, param3 as Param3)
        },
        invocationParameters = listOf(param1, param2, param3)
    )
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    definition: JsSyntaxScope.(
        Param1, Param2
    ) -> Unit
) = +JsFunction2(
    name = name,
    param1 = param1,
    param2 = param2,
    definition = definition
)

class JsFunction2<Param1 : JsValue, Param2 : JsValue>(
    name: String,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
    ) -> Unit,
) : JsFunctionCommons<JsFunction2Ref<Param1, Param2>>(name) {

    override val functionRef: JsFunction2Ref<Param1, Param2> = JsFunction2Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1 as Param1, param2 as Param2)
        },
        invocationParameters = listOf(param1, param2)
    )
}

@JsDsl
fun <Param1 : JsValue> JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    param: JsReference<Param1>,
    definition: JsSyntaxScope.(Param1) -> Unit
) = +JsFunction1(
    name = name,
    param = param,
    definition = definition
)

class JsFunction1<Param1 : JsValue>(
    name: String,
    private val param: JsReference<Param1>,
    private val definition: JsSyntaxScope.(Param1) -> Unit,
) : JsFunctionCommons<JsFunction1Ref<Param1>>(name) {

    override val functionRef: JsFunction1Ref<Param1> = JsFunction1Ref(name)
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param as Param1)
        },
        invocationParameters = listOf(param)
    )
}

@JsDsl
fun JsScriptScope.Function(
    name: String = "function_${JsReference.nextRefInt()}",
    definition: JsSyntaxScope.() -> Unit
) = +JsFunction0(
    name = name,
    definition = definition
)

class JsFunction0(
    name: String,
    private val definition: JsSyntaxScope.() -> Unit,
) : JsFunctionCommons<JsFunction0Ref>(name) {

    override val functionRef: JsFunction0Ref = JsFunction0Ref(name)
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))
}

abstract class JsFunctionCommons<FunctionRef : JsFunctionRefCommons>(
    name: String,
) : JsObjectRef(name) {

    protected abstract val functionRef: FunctionRef
    protected abstract fun buildScopeParameters(): InnerScopeParameters

    protected open fun buildInnerSyntax(scopeParameters: InnerScopeParameters): String = """
        function ${this}(${+scopeParameters.invocationParameters}) {
            ${scopeParameters.scope}
        }
    """.trimIndent()

    internal fun buildSyntax(): JsSyntaxBuilder<FunctionRef> {
        val builder = JsSyntaxBuilder(functionRef)
        val scopeParameters = buildScopeParameters()
        builder.append(
            JsSyntax(value = buildInnerSyntax(scopeParameters))
        )
        return builder
    }

    protected data class InnerScopeParameters(
        val scope: JsSyntaxScope,
        val invocationParameters: List<JsValue> = listOf()
    )
}