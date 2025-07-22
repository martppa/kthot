package net.asere.kotlin.js.dsl.callable

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.extension.unaryPlus
import net.asere.kotlin.js.dsl.reference.*
import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.value.JsValue

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsScriptScope.Lambda(
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
) = with(
    JsLambda5(
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        param5 = param5,
        definition = definition,
    )
) {
    +JsLambdaSyntax(
        reference = JsLambda5.ref<Param1, Param2, Param3, Param4, Param5>("$this"),
        lambda = this,
    )
}

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
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsScriptScope.Lambda(
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
) = with(
    JsLambda4(
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        definition = definition,
    )
) {
    +JsLambdaSyntax(
        reference = JsLambda4.ref<Param1, Param2, Param3, Param4>("$this"),
        lambda = this,
    )
}

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
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsScriptScope.Lambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    param3: JsReference<Param3>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>,
        JsReference<Param3>
    ) -> Unit,
) = with(
    JsLambda3(
        param1 = param1,
        param2 = param2,
        param3 = param3,
        definition = definition,
    )
) {
    +JsLambdaSyntax(
        reference = JsLambda3.ref<Param1, Param2, Param3>("$this"),
        lambda = this,
    )
}

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
fun <Param1 : JsValue, Param2 : JsValue> JsScriptScope.Lambda(
    param1: JsReference<Param1>,
    param2: JsReference<Param2>,
    definition: JsSyntaxScope.(
        JsReference<Param1>,
        JsReference<Param2>
    ) -> Unit,
) = with(
    JsLambda2(
        param1 = param1,
        param2 = param2,
        definition = definition,
    )
) {
    +JsLambdaSyntax(
        reference = JsLambda2.ref<Param1, Param2>("$this"),
        lambda = this,
    )
}

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
fun <Param1 : JsValue> JsScriptScope.Lambda(
    param: JsReference<Param1>,
    definition: JsSyntaxScope.(JsReference<Param1>) -> Unit,
) = with(
    JsLambda1(
        param = param,
        definition = definition
    )
) {
    +JsLambdaSyntax(
        reference = JsLambda1.ref<Param1>("$this"),
        lambda = this
    )
}

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
fun JsScriptScope.Lambda(definition: JsSyntaxScope.() -> Unit) = with(JsLambda0(definition)) {
    +JsLambdaSyntax(
        reference = JsLambda0.ref("$this"),
        lambda = this
    )
}

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