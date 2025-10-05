package net.asere.kthot.js.dsl.type.lambda

import net.asere.kthot.js.dsl.extension.unaryPlus
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsCallable
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.JsObjectRef
import net.asere.kthot.js.dsl.type.obj.ref
import net.asere.kthot.js.dsl.type.value.JsValue

abstract class JsLambdaValue : JsValue, JsCallable {
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