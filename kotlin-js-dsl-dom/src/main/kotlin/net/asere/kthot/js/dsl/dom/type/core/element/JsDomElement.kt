package net.asere.kthot.js.dsl.dom.type.core.element

import net.asere.kthot.js.dsl.dom.type.core.node.JsNode
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
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the base class for objects of elements in a document (the standard DOM 'Element' interface).
 * It extends [JsNode] and introduces properties related to element attributes, IDs, and scrolling.
 */
interface JsDomElement : JsNode {

    /**
     * Reflects the HTML global `id` attribute, representing the element's unique identifier.
     * In JavaScript, this corresponds to `element.id`.
     */
    val id: JsStringRef get() = JsString.ref(ChainOperation(this, "id"))

    /**
     * Reflects the HTML global `class` attribute, representing the space-separated list of the element's CSS classes.
     * In JavaScript, this corresponds to `element.className`.
     */
    val className: JsStringRef get() = JsString.ref(ChainOperation(this, "className"))

    /**
     * Returns a [DOMTokenList] object for the element's `class` attribute, allowing for convenient
     * addition, removal, and toggling of individual CSS classes.
     * In JavaScript, this corresponds to `element.classList`.
     */
    val classList: JsObject get() = JsObject.syntax(ChainOperation(this, "classList")) // Returns DOMTokenList

    /**
     * Returns the name of the element's tag (e.g., "DIV", "A", "P") in uppercase.
     * In JavaScript, this corresponds to `element.tagName`.
     */
    val tagName: JsString get() = JsString.syntax(ChainOperation(this, "tagName"))

    /**
     * Returns a [JsObject] object containing the list of attributes of the element.
     * In JavaScript, this corresponds to `element.attributes`.
     */
    val attributes: JsObject get() = JsObject.syntax(ChainOperation(this, "attributes"))

    /**
     * Reflects the HTML content (markup and text) inside the element.
     * Setting this value replaces the element's content with parsed HTML.
     * In JavaScript, this corresponds to `element.innerHTML`.
     */
    val innerHTML: JsStringRef get() = JsString.ref(ChainOperation(this, "innerHTML"))

    /**
     * Returns the serialized HTML markup of the element, including the element itself.
     * Setting this value replaces the entire element in the DOM.
     * In JavaScript, this corresponds to `element.outerHTML`.
     */
    val outerHTML: JsStringRef get() = JsString.ref(ChainOperation(this, "outerHTML"))

    /**
     * Returns the text content of the element and its descendants, without HTML markup.
     * Setting this value replaces the element's content with plain text.
     * In JavaScript, this corresponds to `element.textContent`.
     */
    val textContent: JsStringRef get() = JsString.ref(ChainOperation(this, "textContent"))

    /**
     * The number of pixels that the content of an element has been scrolled vertically.
     * This property is read/write and is intrinsic to any scrollable [Element].
     * In JavaScript, this corresponds to `element.scrollTop`.
     */
    val scrollTop: JsNumberRef get() = JsNumber.ref(ChainOperation(this, "scrollTop"))

    /**
     * The number of pixels that the content of an element has been scrolled horizontally.
     * This property is read/write and is intrinsic to any scrollable [Element].
     * In JavaScript, this corresponds to `element.scrollLeft`.
     */
    val scrollLeft: JsNumberRef get() = JsNumber.ref(ChainOperation(this, "scrollLeft"))

    /**
     * The height of the element's content, including content not visible on the screen due to overflow.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.scrollHeight`.
     */
    val scrollHeight: JsNumber get() = JsNumber.syntax(ChainOperation(this, "scrollHeight"))

    /**
     * The width of the element's content, including content not visible on the screen due to overflow.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.scrollWidth`.
     */
    val scrollWidth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "scrollWidth"))

    /**
     * Retrieves the value of the named attribute.
     * Corresponds to `element.getAttribute(name)`.
     * @param name A [JsString] representing the attribute name.
     * @return A [JsString] representing the attribute value, or `null` if the attribute does not exist.
     */
    fun getAttribute(name: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("getAttribute", name)))

    /**
     * Sets the value of a named attribute. If the attribute already exists, its value is updated.
     * Corresponds to `element.setAttribute(name, value)`.
     * @param name A [JsString] representing the attribute name.
     * @param value A [JsString] representing the desired attribute value.
     */
    fun setAttribute(name: JsString, value: JsString): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("setAttribute", name, value)))

    /**
     * Removes the named attribute from the current element.
     * Corresponds to `element.removeAttribute(name)`.
     * @param name A [JsString] representing the attribute name.
     */
    fun removeAttribute(name: JsString): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("removeAttribute", name)))

    /**
     * Returns a live [JsHTMLCollection] of the children of the element.
     * Note: Only element nodes are included (not text or comment nodes).
     * In JavaScript, this corresponds to `element.children`.
     */
    val children: JsObject get() = JsObject.syntax(ChainOperation(this, "children")) // Returns HTMLCollection

    /**
     * Returns the number of child elements (element nodes) of the current element.
     * This property is read-only.
     * In JavaScript, this corresponds to `element.childElementCount`.
     */
    val childElementCount: JsNumber get() = JsNumber.syntax(ChainOperation(this, "childElementCount"))

    /**
     * Returns the first child [JsDomElement] of the current element, or `null` if the element has no children.
     * In JavaScript, this corresponds to `element.firstElementChild`.
     */
    val firstElementChild: JsDomElement get() = JsDomElement.syntax(ChainOperation(this, "firstElementChild"))

    /**
     * Returns the last child [JsDomElement] of the current element, or `null` if the element has no children.
     * In JavaScript, this corresponds to `element.lastElementChild`.
     */
    val lastElementChild: JsDomElement get() = JsDomElement.syntax(ChainOperation(this, "lastElementChild"))

    companion object
}