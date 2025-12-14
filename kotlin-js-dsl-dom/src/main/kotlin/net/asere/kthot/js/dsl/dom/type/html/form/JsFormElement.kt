package net.asere.kthot.js.dsl.dom.type.html.form

import net.asere.kthot.js.dsl.dom.type.html.collection.JsHtmlCollection
import net.asere.kthot.js.dsl.dom.type.html.collection.syntax
import net.asere.kthot.js.dsl.dom.type.html.element.JsHtmlElement
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref

/**
 * Represents the JavaScript `HTMLFormElement`, providing access to the properties and methods of an HTML `<form>` element.
 * It extends the base [JsHtmlElement].
 */
interface JsFormElement : JsHtmlElement {

    /**
     * Gets or sets the `action` attribute, which specifies the URL to which the form's data is sent.
     * Corresponds to `form.action` in JavaScript.
     */
    val action: JsStringRef
        get() = JsString.ref(ChainOperation(this, "action"))

    /**
     * Gets or sets the `method` attribute, which specifies the HTTP method for sending data (e.g., "get", "post").
     * Corresponds to `form.method` in JavaScript.
     */
    val method: JsStringRef
        get() = JsString.ref(ChainOperation(this, "method"))

    /**
     * Gets or sets the `enctype` attribute, which specifies how the form data should be encoded when submitting.
     * Corresponds to `form.enctype` in JavaScript.
     */
    val enctype: JsStringRef
        get() = JsString.ref(ChainOperation(this, "enctype"))

    /**
     * Gets or sets the `name` attribute, which is a name for the form.
     * Corresponds to `form.name` in JavaScript.
     * NOTE: Using `formName` to avoid potential conflict with a hypothetical Kotlin keyword or parent property.
     */
    val formName: JsStringRef // Renamed from jsName to formName for clarity
        get() = JsString.ref(ChainOperation(this, "name"))

    /**
     * Gets a [JsHtmlCollection] of all form control elements within the form (e.g., input, select, textarea, button).
     * Corresponds to `form.elements` in JavaScript.
     */
    val elements: JsHtmlCollection
        get() = JsHtmlCollection.syntax(ChainOperation(this, "elements"))

    /**
     * Submits the form.
     * Corresponds to `form.submit()` in JavaScript.
     */
    fun submit(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation( "submit")))

    /**
     * Resets the form to its initial state.
     * Corresponds to `form.reset()` in JavaScript.
     */
    fun reset(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation( "reset")))

    companion object
}