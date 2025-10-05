package net.asere.kthot.js.dsl.dom.type.structure.form

import net.asere.kthot.js.dsl.dom.type.data.array.JsDomArray
import net.asere.kthot.js.dsl.dom.type.data.array.syntax
import net.asere.kthot.js.dsl.dom.type.data.obj.JsDomObject
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `HTMLFormElement`, providing access to the properties and methods of an HTML `<form>` element.
 */
interface JsForm : JsDomObject {

    /**
     * Gets or sets the `action` attribute, which specifies the URL to which the form's data is sent.
     * Corresponds to `form.action` in JavaScript.
     */
    val action: JsString get() = JsString.syntax(ChainOperation(this, "action"))

    /**
     * Method` attribute, which specifies the HTTP method for sending data (e.g., "get", "post").
     * Corresponds to `form.method` in JavaScript.
     */
    val method: JsString get() = JsString.syntax(ChainOperation(this, "method"))

    /**
     * Enctype` attribute, which specifies how the form data should be encoded when submitting.
     * Corresponds to `form.enctype` in JavaScript.
     */
    val enctype: JsString get() = JsString.syntax(ChainOperation(this, "enctype"))

    /**
     * Name` attribute, which is a name for the form.
     * Corresponds to `form.name` in JavaScript.
     */
    val jsName: JsString get() = JsString.syntax(ChainOperation(this, "name"))

    /**
     * Gets a `HTMLCollection` of all elements within the form.
     * Corresponds to `form.elements` in JavaScript.
     */
    val elements: JsDomArray get() = JsDomArray.syntax(ChainOperation(this, "elements"))

    /**
     * Submits the form.
     * Corresponds to `form.submit()` in JavaScript.
     */
    fun submit(): JsSyntax = ChainOperation(this, InvocationOperation( "submit"))

    /**
     * Resets the form to its initial state.
     * Corresponds to `form.reset()` in JavaScript.
     */
    fun reset(): JsSyntax = ChainOperation(this, InvocationOperation( "reset"))

    companion object
}