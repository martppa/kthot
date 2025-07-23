package net.asere.kotlin.js.dsl.callable

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.extension.unaryPlus
import net.asere.kotlin.js.dsl.reference.*
import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.value.JsValue

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> Lambda(
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
    ) -> Unit,
) = JsLambda5.ref<Param1, Param2, Param3, Param4, Param5>(
    "${
        JsLambda5(
            param1 = param1,
            param2 = param2,
            param3 = param3,
            param4 = param4,
            param5 = param5,
            definition = definition,
        )
    }"
)

class JsLambda5<
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue>(
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val param4: JsReference<Param4>,
    private val param5: JsReference<Param5>,
    private val definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>,
        JsReference<Param4>,
        JsReference<Param5>
    ) -> Unit,
) : JsLambdaCommons() {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3, param4, param5)
        },
        invocationParameters = listOf(param1, param2, param3, param4, param5)
    )

    companion object
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> Lambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    param4: JsReference<Param4>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>,
        JsReference<Param4>
    ) -> Unit,
) = JsLambda4.ref<Param1, Param2, Param3, Param4>(
    "${
        JsLambda4(
            param1 = param1,
            param2 = param2,
            param3 = param3,
            param4 = param4,
            definition = definition,
        )
    }"
)

class JsLambda4<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
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
) : JsLambdaCommons() {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3, param4)
        },
        invocationParameters = listOf(param1, param2, param3, param4)
    )

    companion object
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> Lambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>
    ) -> Unit,
) = JsLambda3.ref<Param1, Param2, Param3>(
    "${
        JsLambda3(
            param1 = param1,
            param2 = param2,
            param3 = param3,
            definition = definition,
        )
    }"
)

class JsLambda3<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val param3: JsReference<Param3>,
    private val definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>
    ) -> Unit,
) : JsLambdaCommons() {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2, param3)
        },
        invocationParameters = listOf(param1, param2, param3)
    )

    companion object
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue> Lambda(
    param1: JsReference<Param1>, param2: JsReference<Param2>,
    definition: JsSyntaxScope.(JsReference<Param1>, JsReference<Param2>) -> Unit,
) = JsLambda2.ref<Param1, Param2>(
    "${
        JsLambda2(
            param1 = param1,
            param2 = param2,
            definition = definition
        )
    }"
)

class JsLambda2<Param1 : JsValue, Param2 : JsValue>(
    private val param1: JsReference<Param1>,
    private val param2: JsReference<Param2>,
    private val definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>
    ) -> Unit,
) : JsLambdaCommons() {

    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1, param2)
        },
        invocationParameters = listOf(param1, param2)
    )

    companion object
}

@JsDsl
fun <Param1 : JsValue> Lambda(
    param: JsReference<Param1>,
    definition: JsSyntaxScope.(JsReference<Param1>) -> Unit,
) = JsLambda1.ref<Param1>(
    "${
        JsLambda1(
            param = param,
            definition = definition
        )
    }"
)

class JsLambda1<Param1 : JsValue>(
    private val param: JsReference<Param1>,
    private val definition: JsSyntaxScope.(JsReference<Param1>) -> Unit,
) : JsLambdaCommons() {
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param)
        },
        invocationParameters = listOf(param)
    )

    companion object
}

@JsDsl
fun Lambda(
    definition: JsSyntaxScope.() -> Unit,
) = JsLambda0.ref(
    "${
        JsLambda0(
            definition = definition
        )
    }"
)

class JsLambda0(
    private val definition: JsSyntaxScope.() -> Unit,
) : JsLambdaCommons() {
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))

    companion object
}

abstract class JsLambdaCommons : JsElement {
    protected abstract fun buildScopeParameters(): InnerScopeParameters

    protected open fun buildInnerSyntax(scopeParameters: InnerScopeParameters): String = """
        (${+scopeParameters.invocationParameters}) => {
            ${scopeParameters.scope}
        }
    """.trimIndent()

    internal fun buildSyntax(): JsSyntaxBuilder<JsObjectRef> {
        val builder = JsSyntaxBuilder(JsObject.ref())
        val scopeParameters = buildScopeParameters()
        builder.append(
            JsSyntax(value = buildInnerSyntax(scopeParameters))
        )
        return builder
    }

    override fun present(): String = buildSyntax().present()

    override fun toString() = present()

    protected data class InnerScopeParameters(
        val scope: JsSyntaxScope,
        val invocationParameters: List<JsValue> = listOf()
    )
}