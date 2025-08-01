package net.asere.kotlin.js.dsl.dom.type.token.list

import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.JsBooleanSyntax
import net.asere.kotlin.js.dsl.type.bool.js
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.reference.lambda.JsLambda1Ref
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.undefined

/**
 * Represents the JavaScript `DOMTokenList` object.
 * This object is returned by properties like `Element.classList` and provides methods
 * for working with space-separated tokens (like class names) on an attribute.
 */
interface JsDomTokenList : JsObject {

    /**
     * Returns the number of tokens in the list as a [net.asere.kotlin.js.dsl.type.number.JsNumber] object.
     *
     * In JavaScript, this corresponds to `tokenList.length`.
     */
    val length: JsNumber get() = JsNumberSyntax(ChainOperation(this, "length"))

    /**
     * Returns the token at the specified index as a [net.asere.kotlin.js.dsl.type.string.JsString] object.
     *
     * In JavaScript, this corresponds to `tokenList.item(index)` or `tokenList[index]`.
     * @param index The zero-based index of the token to retrieve as a [JsNumber] object.
     * @return A [net.asere.kotlin.js.dsl.type.string.JsString] object representing the token at the specified index.
     */
    fun item(index: JsNumber): JsString = JsStringSyntax(ChainOperation(this, InvocationOperation("item", index)))
    fun item(index: Int): JsString = item(index.js)

    /**
     * Adds one or more tokens to the list.
     *
     * In JavaScript, this corresponds to `tokenList.add(token1, token2, ...)`.
     * @param tokens A variable number of [JsString] objects representing the tokens to add.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun add(vararg tokens: JsString): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("add", *tokens)))
    fun add(vararg tokens: String): JsSyntax = add(*tokens.map { it.js }.toTypedArray())

    /**
     * Removes one or more tokens from the list.
     *
     * In JavaScript, this corresponds to `tokenList.remove(token1, token2, ...)`.
     * @param tokens A variable number of [JsString] objects representing the tokens to remove.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun remove(vararg tokens: JsString): JsSyntax = JsSyntax(
        ChainOperation(this,
            InvocationOperation("remove", *tokens))
    )
    fun remove(vararg tokens: String): JsSyntax = remove(*tokens.map { it.js }.toTypedArray())

    /**
     * Toggles a token in the list. If the token is present, it's removed; if not, it's added.
     *
     * In JavaScript, this corresponds to `tokenList.toggle(token, force)`.
     * @param token The [JsString] object representing the token to toggle.
     * @param force An optional [net.asere.kotlin.js.dsl.type.bool.JsBoolean] object. If `true`, the token is added. If `false`, it's removed.
     * @return A [net.asere.kotlin.js.dsl.type.bool.JsBoolean] object indicating whether the token is now present in the list.
     */
    fun toggle(token: JsString, force: JsBoolean? = null): JsBoolean =
        JsBooleanSyntax(
            ChainOperation(
                this,
                InvocationOperation("toggle", token, force ?: undefined)
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
        JsBooleanSyntax(ChainOperation(this, InvocationOperation("contains", token)))
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
        JsBooleanSyntax(ChainOperation(this,
            InvocationOperation("replace", oldToken, newToken))
        )
    fun replace(oldToken: String, newToken: String): JsBoolean = replace(oldToken.js, newToken.js)

    /**
     * Returns a new `Iterator` object that contains the `[index, value]` pairs for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.entries()`.
     * @return A [JsSyntax] object representing the JavaScript method call that returns an Iterator.
     */
    fun entries(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("entries")))

    /**
     * Returns a new `Iterator` object that contains the keys (indices) for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.keys()`.
     * @return A [JsSyntax] object representing the JavaScript method call that returns an Iterator.
     */
    fun keys(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("keys")))

    /**
     * Returns a new `Iterator` object that contains the values (tokens) for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.values()`.
     * @return A [JsSyntax] object representing the JavaScript method call that returns an Iterator.
     */
    fun values(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("values")))

    /**
     * Executes a provided function once for each token in the list.
     *
     * In JavaScript, this corresponds to `tokenList.forEach(callback)`.
     * @param callback A [JsLambda1Ref] representing the JavaScript function to execute for each token.
     * The function typically receives the current token as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun forEach(callback: JsLambda1Ref<JsDomObject>): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("forEach", callback)))

    companion object
}