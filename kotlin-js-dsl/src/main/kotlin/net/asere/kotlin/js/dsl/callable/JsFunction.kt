package net.asere.kotlin.js.dsl.callable

import net.asere.kotlin.js.dsl.extension.unaryPlus
import net.asere.kotlin.js.dsl.reference.JsFunction1Ref
import net.asere.kotlin.js.dsl.reference.JsFunction2Ref
import net.asere.kotlin.js.dsl.reference.JsFunction3Ref
import net.asere.kotlin.js.dsl.reference.JsFunction4Ref
import net.asere.kotlin.js.dsl.reference.JsFunction5Ref
import net.asere.kotlin.js.dsl.reference.JsRawFunctionRef
import net.asere.kotlin.js.dsl.reference.JsFunctionRef
import net.asere.kotlin.js.dsl.reference.JsFunctionRefCommons
import net.asere.kotlin.js.dsl.reference.JsValueRef
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.value.JsValue

class JsRawFunction(
    name: String? = null,
    private vararg val params: JsReference<*>,
    private val definition: JsSyntaxScope.() -> Unit,
) : JsFunctionCommons<JsRawFunctionRef>(name) {

    override val functionRef: JsRawFunctionRef = JsRawFunctionRef(name)
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply { definition(this) },
        invocationParameters = params.toList(),
    )
}

fun <Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue> JsFunction(
    name: String? = null,
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    param4: JsReference<Param4>,
    param5: JsReference<Param5>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>,
        JsReference<Param4>,
        JsReference<Param5>
    ) -> Unit
) = JsFunction5(
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
    name: String? = null,
    private val param1: Param1,
    private val param2: Param2,
    private val param3: Param3,
    private val param4: Param4,
    private val param5: Param5,
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
            definition(this, param1, param2, param3, param4, param5)
        },
        invocationParameters = listOf(param1, param2, param3, param4, param5)
    )

}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsFunction(
    name: String? = null,
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    param4: JsReference<Param4>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>,
        JsReference<Param4>
    ) -> Unit
) = JsFunction4(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    definition = definition
)

class JsFunction4<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String? = null,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val param4: JsReference<Param4>,
    private val definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>,
        JsReference<Param4>
    ) -> Unit,
) : JsFunctionCommons<JsFunction4Ref<Param1, Param2, Param3, Param4>>(name) {

    override val functionRef: JsFunction4Ref<Param1, Param2, Param3, Param4> = JsFunction4Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3, param4)
        },
        invocationParameters = listOf(param1, param2, param3, param4)
    )
}

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsFunction(
    name: String? = null,
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>
    ) -> Unit
) = JsFunction3(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    definition = definition
)

class JsFunction3<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String? = null,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>
    ) -> Unit,
) : JsFunctionCommons<JsFunction3Ref<Param1, Param2, Param3>>(name) {

    override val functionRef: JsFunction3Ref<Param1, Param2, Param3> = JsFunction3Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3)
        },
        invocationParameters = listOf(param1, param2, param3)
    )
}

fun <Param1 : JsValue, Param2 : JsValue> JsFunction(
    name: String? = null,
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    definition: JsSyntaxScope.(
        JsReference<Param1>, JsReference<Param2>
    ) -> Unit
) = JsFunction2(
    name = name,
    param1 = param1,
    param2 = param2,
    definition = definition
)

class JsFunction2<Param1 : JsValue, Param2 : JsValue>(
    name: String? = null,
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>
    ) -> Unit,
) : JsFunctionCommons<JsFunction2Ref<Param1, Param2>>(name) {

    override val functionRef: JsFunction2Ref<Param1, Param2> = JsFunction2Ref(name)

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2)
        },
        invocationParameters = listOf(param1, param2)
    )
}

fun <Param1 : JsValue> JsFunction(
    name: String? = null,
    param: JsReference<Param1>,
    definition: JsSyntaxScope.(JsReference<Param1>) -> Unit
) = JsFunction1(
    name = name,
    param = param,
    definition = definition
)

class JsFunction1<Param1 : JsValue>(
    name: String? = null,
    private val param: JsReference<Param1>,
    private val definition: JsSyntaxScope.(JsReference<Param1>) -> Unit,
) : JsFunctionCommons<JsFunction1Ref<Param1>>(name) {

    override val functionRef: JsFunction1Ref<Param1> = JsFunction1Ref(name)
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param)
        },
        invocationParameters = listOf(param)
    )
}

class JsFunction(
    name: String? = null,
    private val definition: JsSyntaxScope.() -> Unit,
) : JsFunctionCommons<JsFunctionRef>(name) {

    override val functionRef: JsFunctionRef = JsFunctionRef(name)
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))
}

abstract class JsFunctionCommons<FunctionRef : JsFunctionRefCommons>(
    name: String? = null,
) : JsValueRef<JsValue>(name ?: "function_${JsReference.nextRefInt()}") {

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