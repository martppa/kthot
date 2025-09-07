package net.asere.kotlin.js.dsl.type.function.f0

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.JsFunctionCommons
import net.asere.kotlin.js.dsl.type.function.f0.JsResultFunction0Ref
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Defines a JavaScript function with no parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName() {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the function body.
 */
@JsDsl
inline fun <reified Result : JsValue> JsScope.ResultFunction0(
    name: String = "function_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.() -> Result
) = +JsReturningFunction0(
    name = name,
    resultTypeBuilder = { syntax ->
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition() }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    definition = definition
)

/**
 * Represents a JavaScript function that takes no parameters.
 * This class is used internally by the [ResultFunction0] DSL extension to build the JavaScript syntax for the function.
 *
 * @param name The name of the function.
 * @param resultTypeBuilder The builder for the returned type. Use the [ResultFunction0] builder if you don't know what to provide here]
 * @param definition A lambda that defines the content of the function's body.
 */
open class JsReturningFunction0<Result : JsValue>(
    name: String,
    resultTypeBuilder: (JsElement) -> Result,
    private val definition: JsSyntaxScope.() -> Result,
) : JsFunctionCommons<JsResultFunction0Ref<Result>>(name) {

    /**
     * The [JsResultFunction0Ref] instance that refers to this function.
     */
    override val functionRef: JsResultFunction0Ref<Result> = JsResultFunction0Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder
    )

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope].
     * @return An [InnerScopeParameters] object containing the function's body.
     */
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply { definition() })
}