package net.asere.kotlin.js.dsl.type.function

import net.asere.kotlin.js.dsl.extension.unaryPlus
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.obj.JsObjectRef
import net.asere.kotlin.js.dsl.type.value.JsValue

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