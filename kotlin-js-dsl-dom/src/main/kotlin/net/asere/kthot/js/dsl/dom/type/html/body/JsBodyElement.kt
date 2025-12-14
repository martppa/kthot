package net.asere.kthot.js.dsl.dom.type.html.body

import net.asere.kthot.js.dsl.dom.type.html.element.JsHtmlElement
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.type.lambda.l0.JsLambda0
import net.asere.kthot.js.dsl.type.lambda.l0.JsLambda0Ref
import net.asere.kthot.js.dsl.type.lambda.l0.ref
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref

/**
 * Represents the JavaScript `HTMLBodyElement` interface, corresponding to the `<body>` element.
 * It extends the base [JsHtmlElement] and adds body-specific properties, primarily event handlers
 * for load/unload.
 */
interface JsBodyElement : JsHtmlElement {

    /** Gets/sets the text color of the document body (Deprecated). Corresponds to `document.body.text`. */
    val text: JsStringRef
        get() = JsString.ref(ChainOperation(this, "text"))

    /** Gets/sets the background color of the document body (Deprecated). Corresponds to `document.body.bgColor`. */
    val bgColor: JsStringRef
        get() = JsString.ref(ChainOperation(this, "bgColor"))

    /**
     * Gets/sets the event handler for the `onload` event. Fires when the page is fully loaded.
     * Corresponds to `document.body.onload`.
     */
    val onload: JsLambda0Ref
        get() = JsLambda0.ref(ChainOperation(this, "onload"))

    /**
     * Gets/sets the event handler for the `onunload` event. Fires when the document is about to be unloaded.
     * Corresponds to `document.body.onunload`.
     */
    val onunload: JsLambda0Ref
        get() = JsLambda0.ref(ChainOperation(this, "onunload"))

    /**
     * Gets/sets the event handler for the `onresize` event. Fires when the window is resized.
     * Corresponds to `document.body.onresize`.
     */
    val onresize: JsLambda0Ref
        get() = JsLambda0.ref(ChainOperation(this, "onresize"))

    companion object
}