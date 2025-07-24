@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.types.type.function

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.function.JsFunctionRef

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
) : JsFunctionCommons<JsFunctionRef>(name) {

    override val functionRef: JsFunctionRef = JsFunctionRef(name)
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))
}