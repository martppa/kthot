package net.asere.kthot.js.dsl.dom.type.html.element

import net.asere.kthot.js.dsl.dom.type.core.element.JsDomElement
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.JsNumberRef
import net.asere.kthot.js.dsl.type.number.ref
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref

/**
 * Represents the base class for objects of all HTML elements (the standard DOM 'HTMLElement' interface).
 * It extends [JsDomElement] with HTML-specific properties like style, lang, and offset dimensions.
 */
interface JsHtmlElement : JsDomElement {

    /**
     * Reflects the HTML global `title` attribute, containing advisory information about the element.
     * In JavaScript, this corresponds to `element.title`.
     */
    val title: JsStringRef get() = JsString.ref(ChainOperation(this, "title"))

    /**
     * Reflects the HTML global `lang` attribute, specifying the primary language for the element's content.
     * In JavaScript, this corresponds to `element.lang`.
     */
    val lang: JsStringRef get() = JsString.ref(ChainOperation(this, "lang"))

    /**
     * Reflects the HTML global `dir` attribute, indicating the text writing direction (e.g., "ltr", "rtl").
     * In JavaScript, this corresponds to `element.dir`.
     */
    val dir: JsStringRef get() = JsString.ref(ChainOperation(this, "dir"))

    /**
     * Reflects the HTML global `tabindex` attribute, indicating if the element can be focused
     * and if so, the order in which it participates in sequential keyboard navigation.
     * In JavaScript, this corresponds to `element.tabIndex`.
     */
    val tabIndex: JsNumberRef get() = JsNumber.ref(ChainOperation(this, "tabIndex"))

    /**
     * Represents the style attribute of the element.
     * This provides access to the element's inline style declarations as a [CSSStyleDeclaration] object.
     * In JavaScript, this corresponds to `element.style`.
     */
    val style: JsObject get() = JsObject.syntax(ChainOperation(this, "style")) // Corresponds to CSSStyleDeclaration

    /**
     * Returns the closest ancestor element that has a position other than `static`.
     * If no such element exists, it returns the `<body>` or `null`.
     * In JavaScript, this corresponds to `element.offsetParent`.
     */
    val offsetParent: JsHtmlElement get() = JsHtmlElement.syntax(ChainOperation(this, "offsetParent"))

    /**
     * The distance (in pixels) from the current element's top border edge to the top of its `offsetParent`.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.offsetTop`.
     */
    val offsetTop: JsNumber get() = JsNumber.syntax(ChainOperation(this, "offsetTop"))

    /**
     * The distance (in pixels) from the current element's left border edge to the left of its `offsetParent`.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.offsetLeft`.
     */
    val offsetLeft: JsNumber get() = JsNumber.syntax(ChainOperation(this, "offsetLeft"))

    /**
     * The width (in pixels) of the element's visual layout, including padding and borders.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.offsetWidth`.
     */
    val offsetWidth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "offsetWidth"))

    /**
     * The height (in pixels) of the element's visual layout, including padding and borders.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.offsetHeight`.
     */
    val offsetHeight: JsNumber get() = JsNumber.syntax(ChainOperation(this, "offsetHeight"))


    /**
     * Sets focus on the specified element, if it is focusable (e.g., input fields, links).
     * Corresponds to `element.focus()`.
     */
    fun focus(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("focus")))

    /**
     * Removes focus from the specified element, if it is currently focused.
     * Corresponds to `element.blur()`.
     */
    fun blur(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("blur")))

    companion object
}