package net.asere.kthot.js.dsl.dom.type.data.token.list

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.js
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1Ref
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.Undefined

/**
 * Represents the JavaScript `DOMTokenList` object.
 * This object is returned by properties like `Element.classList` and provides methods
 * for working with space-separated tokens (like class names) on an attribute.
 */
interface JsDomTokenList : JsObject {

    /**
     * Returns the number of tokens in the list as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `tokenList.length`.
     */
    val length: JsNumber get() = JsNumber.syntax(ChainOperation(this, "length"))

    /**
     * Returns the token at the specified index as a [JsString] object.
     *
     * In JavaScript, this corresponds to `tokenList.item(index)` or `tokenList[index]`.
     * @param index The zero-based index of the token to retrieve as a [JsNumber] object.
     * @return A [JsString] object representing the token at the specified index.
     */
    fun item(index: JsNumber): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("item", index)))
    fun item(index: Int): JsString = item(index.js)

    /**
     * Adds one or more tokens to the list.
     *
     * In JavaScript, this corresponds to `tokenList.add(token1, token2, ...)`.
     * @param tokens A variable number of [JsString] objects representing the tokens to add.
     * @return A [JsNothing] object representing the JavaScript method call.
     */
    fun add(vararg tokens: JsString): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("add", *tokens)))
    fun add(vararg tokens: String): JsSyntax = add(*tokens.map { it.js }.toTypedArray())

    /**
     * Removes one or more tokens from the list.
     *
     * In JavaScript, this corresponds to `tokenList.remove(token1, token2, ...)`.
     * @param tokens A variable number of [JsString] objects representing the tokens to remove.
     * @return A [JsNothing] object representing the JavaScript method call.
     */
    fun remove(vararg tokens: JsString): JsNothing = JsNothing.syntax(
        ChainOperation(this,
            InvocationOperation("remove", *tokens))
    )
    fun remove(vararg tokens: String): JsNothing = remove(*tokens.map { it.js }.toTypedArray())

    /**
     * Toggles a token in the list. If the token is present, it's removed; if not, it's added.
     *
     * In JavaScript, this corresponds to `tokenList.toggle(token, force)`.
     * @param token The [JsString] object representing the token to toggle.
     * @param force An optional [JsBoolean] object. If `true`, the token is added. If `false`, it's removed.
     * @return A [JsBoolean] object indicating whether the token is now present in the list.
     */
    fun toggle(token: JsString, force: JsBoolean? = null): JsBoolean =
        JsBoolean.syntax(
            ChainOperation(
                this,
                InvocationOperation("toggle", token, force ?: Undefined)
            )
        )
    fun toggle(token: String, force: Boolean? = null): JsBoolean = toggle(token.js, force?.js)

    /**
     * Checks if the list contains a specific token.
     *
     * In JavaScript, this corresponds to `tokenList.contains(token)`.
     * @param token The [JsString] object representing the token to check for.
     * @return A [JsBoolean] object indicating whether the token is present in the list.
     */
    fun contains(token: JsString): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("contains", token)))
    fun contains(token: String): JsBoolean = contains(token.js)

    /**
     * Replaces an existing token with a new token.
     *
     * In JavaScript, this corresponds to `tokenList.replace(oldToken, newToken)`.
     * @param oldToken The [JsString] object representing the token to replace.
     * @param newToken The [JsString] object representing the new token.
     * @return A [JsBoolean] object indicating whether the replacement was successful.
     */
    fun replace(oldToken: JsString, newToken: JsString): JsBoolean =
        JsBoolean.syntax(ChainOperation(this,
            InvocationOperation("replace", oldToken, newToken))
        )
    fun replace(oldToken: String, newToken: String): JsBoolean = replace(oldToken.js, newToken.js)

    /**
     * Returns a new `Iterator` object that contains the `[index, value]` pairs for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.entries()`.
     * @return A [JsNothing] object representing the JavaScript method call that returns an Iterator.
     */
    fun entries(): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("entries")))

    /**
     * Returns a new `Iterator` object that contains the keys (indices) for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.keys()`.
     * @return A [JsNothing] object representing the JavaScript method call that returns an Iterator.
     */
    fun keys(): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("keys")))

    /**
     * Returns a new `Iterator` object that contains the values (tokens) for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.values()`.
     * @return A [JsNothing] object representing the JavaScript method call that returns an Iterator.
     */
    fun values(): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("values")))

    /**
     * Executes a provided function once for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.forEach(callback)`.
     * @param callback A [JsLambda1Ref] representing the JavaScript function to execute for each token.
     * The function typically receives the current token as its first argument.
     * @return A [JsNothing] object representing the JavaScript method call.
     */
    fun forEach(callback: JsLambda1Ref<JsString>): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("forEach", callback)))

    companion object
}