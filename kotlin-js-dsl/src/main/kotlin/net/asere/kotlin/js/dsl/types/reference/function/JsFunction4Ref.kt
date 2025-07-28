package net.asere.kotlin.js.dsl.types.reference.function

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.types.value.JsValue

/**
 * Represents a reference to a JavaScript function that takes four parameters.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it with four arguments, generating the corresponding JavaScript call syntax.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @param Param2 The type of the second parameter that the JavaScript function expects.
 * @param Param3 The type of the third parameter that the JavaScript function expects.
 * @param Param4 The type of the fourth parameter that the JavaScript function expects.
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsFunction4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    /**
     * Invokes the JavaScript function with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName(param1, param2, param3, param4);
     * ```
     * or for anonymous functions:
     * ```javascript
     * functionReference(param1, param2, param3, param4);
     * ```
     * @param param1 The [Param1] value to pass as the first argument to the function.
     * @param param2 The [Param2] value to pass as the second argument to the function.
     * @param param3 The [Param3] value to pass as the third argument to the function.
     * @param param4 The [Param4] value to pass as the fourth argument to the function.
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4) =
        JsSyntax(InvocationOperation(this, param1, param2, param3, param4))
}