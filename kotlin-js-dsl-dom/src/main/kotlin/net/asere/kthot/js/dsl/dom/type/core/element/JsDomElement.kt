package net.asere.kthot.js.dsl.dom.type.core.element

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.dom.type.core.node.JsNode
import net.asere.kthot.js.dsl.dom.type.core.node.list.JsNodeList
import net.asere.kthot.js.dsl.dom.type.core.node.list.syntax
import net.asere.kthot.js.dsl.dom.type.data.token.list.JsDomTokenList
import net.asere.kthot.js.dsl.dom.type.data.token.list.JsDomTokenListRef
import net.asere.kthot.js.dsl.dom.type.data.token.list.ref
import net.asere.kthot.js.dsl.dom.type.data.token.list.syntax
import net.asere.kthot.js.dsl.dom.type.html.collection.JsHtmlCollection
import net.asere.kthot.js.dsl.dom.type.html.collection.syntax
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.js
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.JsNumberRef
import net.asere.kthot.js.dsl.type.number.ref
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.ref
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `Element` interface. This is the fundamental interface for all elements
 * in a document (HTML, SVG, etc.). It extends [JsNode] and provides core element-specific features
 * like attributes, classes, and content manipulation.
 */
interface JsDomElement : JsNode {

    /**
     * Returns a [JsDomElement] representing the <slot> the node is inserted in.
     */
    val assignedSlot: JsDomElement get() = JsDomElement.syntax(ChainOperation(this, "assignedSlot"))

    /**
     * A number indicating the effective zoom size of the element, or 1.0 if the element is not rendered.
     */
    val currentCssZoom: JsNumber get() = JsNumber.syntax(ChainOperation(this, "currentCssZoom"))

    /**
     * A string reflecting the elementtiming attribute which marks an element for observation in the PerformanceElementTiming API.
     */
    val elementTiming: JsStringRef get() = JsString.ref(ChainOperation(this, "elementTiming"))

    /**
     * A string representing the local part of the qualified name of the element.
     */
    val localName: JsString get() = JsString.syntax(ChainOperation(this, "localName"))

    /**
     * The namespace URI of the element, or null if it is no namespace.
     */
    val namespaceURI: JsString get() = JsString.syntax(ChainOperation(this, "namespaceURI"))

    /**
     * Represents the part identifier(s) of the element (i.e., set using the part attribute), returned as a [JsDomTokenList].
     */
    val part: JsDomTokenListRef get() = JsDomTokenList.ref(ChainOperation(this, "part"))

    /**
     * A string representing the namespace prefix of the element, or null if no prefix is specified.
     */
    val prefix: JsString get() = JsString.syntax(ChainOperation(this, "prefix"))

    /**
     * Gets or sets the value of the `id` attribute.
     * Corresponds to `element.id` in JavaScript.
     */
    val id: JsStringRef
        get() = JsString.ref(ChainOperation(this, "id"))

    /**
     * Gets or sets the value of the `class` attribute.
     * Corresponds to `element.className` in JavaScript.
     */
    val className: JsStringRef
        get() = JsString.ref(ChainOperation(this, "className"))

    /**
     * Gets a token list for managing the element's classes.
     * Corresponds to `element.classList` in JavaScript.
     */
    val classList: JsDomTokenList
        get() = JsDomTokenList.syntax(ChainOperation(this, "classList"))

    /**
     * Gets the name of the tag (e.g., "DIV", "BUTTON").
     * Corresponds to `element.tagName` in JavaScript.
     */
    val tagName: JsString
        get() = JsString.syntax(ChainOperation(this, "tagName"))

    /**
     * Gets the list of attributes assigned to the element. (Read-only)
     * Corresponds to `element.attributes`.
     */
    val attributes: JsObject
        get() = JsObject.syntax(ChainOperation(this, "attributes"))

    /**
     * Gets the inner height of an element (content + padding).
     * Corresponds to `element.clientHeight`.
     */
    val clientHeight: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "clientHeight"))

    /**
     * Gets the inner width of an element (content + padding).
     * Corresponds to `element.clientWidth`.
     */
    val clientWidth: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "clientWidth"))

    /**
     * Gets the width of the left border of the element.
     * Corresponds to `element.clientLeft`.
     */
    val clientLeft: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "clientLeft"))

    /**
     * Gets the width of the top border of the element.
     * Corresponds to `element.clientTop`.
     */
    val clientTop: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "clientTop"))

    /**
     * Gets the full height of the element's content, visible or not.
     * Corresponds to `element.scrollHeight`.
     */
    val scrollHeight: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "scrollHeight"))

    /**
     * Gets the full width of the element's content, visible or not.
     * Corresponds to `element.scrollWidth`.
     */
    val scrollWidth: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "scrollWidth"))

    /**
     * Gets or sets the left scroll offset of the element.
     * Corresponds to `element.scrollLeft`.
     */
    val scrollLeft: JsNumberRef
        get() = JsNumber.ref(ChainOperation(this, "scrollLeft"))

    /**
     * Gets or sets the top scroll offset of the element.
     * Corresponds to `element.scrollTop`.
     */
    val scrollTop: JsNumberRef
        get() = JsNumber.ref(ChainOperation(this, "scrollTop"))

    /**
     * Returns a number representing the maximum top scroll offset possible for the element.
     */
    val scrollTopMax: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "scrollTopMax"))

    /**
     * Returns the open shadow root that is hosted by the element, or null if no open shadow root is present.
     */
    val shadowRoot: JsObject
        get() = JsObject.syntax(ChainOperation(this, "shadowRoot"))

    /**
     * Returns the number of child elements.
     * Corresponds to `element.childElementCount`.
     */
    val childElementCount: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "childElementCount"))

    /**
     * Returns a live [JsHtmlCollection] of all child elements (excluding text/comment nodes).
     * Corresponds to `element.children`.
     */
    val children: JsHtmlCollection
        get() = JsHtmlCollection.syntax(ChainOperation(this, "children"))

    /**
     * Returns the first child element of this element, or null.
     * Corresponds to `element.firstElementChild`.
     */
    val firstElementChild: JsDomElement
        get() = JsDomElement.syntax(ChainOperation(this, "firstElementChild"))

    /**
     * Returns the last child element of this element, or null.
     * Corresponds to `element.lastElementChild`.
     */
    val lastElementChild: JsDomElement
        get() = JsDomElement.syntax(ChainOperation(this, "lastElementChild"))

    /**
     * Returns the element immediately following the given one in the tree, or null.
     * Corresponds to `element.nextElementSibling`.
     */
    val nextElementSibling: JsDomElement
        get() = JsDomElement.syntax(ChainOperation(this, "nextElementSibling"))

    /**
     * Returns the element immediately preceding the given one in the tree, or null.
     * Corresponds to `element.previousElementSibling`.
     */
    val previousElementSibling: JsDomElement
        get() = JsDomElement.syntax(ChainOperation(this, "previousElementSibling"))

    /**
     * Returns the name of the shadow DOM slot the element is inserted in.
     * Corresponds to `element.slot`.
     */
    val slot: JsStringRef
        get() = JsString.ref(ChainOperation(this, "slot"))

    /**
     * Gets or sets the HTML markup content of an element.
     * Corresponds to `element.innerHTML`.
     */
    val innerHTML: JsStringRef
        get() = JsString.ref(ChainOperation(this, "innerHTML"))

    /**
     * Gets or sets the element's markup, including the element itself.
     * Corresponds to `element.outerHTML`.
     */
    val outerHTML: JsStringRef
        get() = JsString.ref(ChainOperation(this, "outerHTML"))

    /**
     * Retrieves the value of the named attribute.
     * Corresponds to `element.getAttribute(name)`.
     */
    fun getAttribute(name: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("getAttribute", name)))

    fun getAttribute(name: String): JsString = getAttribute(name.js)

    /**
     * Sets the value of the named attribute.
     * Corresponds to `element.setAttribute(name, value)`.
     */
    fun setAttribute(name: JsString, value: JsString): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("setAttribute", name, value)))

    fun setAttribute(name: String, value: String): JsNothing = setAttribute(name.js, value.js)

    /**
     * Removes the named attribute.
     * Corresponds to `element.removeAttribute(name)`.
     */
    fun removeAttribute(name: JsString): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("removeAttribute", name)))

    fun removeAttribute(name: String): JsNothing = removeAttribute(name.js)

    /**
     * Returns a [JsBoolean] indicating whether the element has the specified attribute.
     * Corresponds to `element.hasAttribute(name)`.
     */
    fun hasAttribute(name: JsString): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("hasAttribute", name)))

    fun hasAttribute(name: String): JsBoolean = hasAttribute(name.js)

    /**
     * Toggles a boolean attribute, removing it if present, adding it if not.
     * Corresponds to `element.toggleAttribute(name, force)`.
     */
    fun toggleAttribute(name: JsString, force: JsBoolean? = null): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("toggleAttribute", *listOfNotNull(name, force).toTypedArray())))

    fun toggleAttribute(name: String, force: Boolean? = null): JsBoolean = toggleAttribute(name.js, force?.js)

    /**
     * Returns the first element matching the specified selector string relative to the element.
     * Corresponds to `element.querySelector(selectors)`.
     */
    fun querySelector(selectors: JsString): JsDomElement =
        JsDomElement.syntax(ChainOperation(this, InvocationOperation("querySelector", selectors)))

    fun querySelector(selectors: String): JsDomElement = querySelector(selectors.js)

    /**
     * Returns a static [JsNodeList] of nodes matching the specified selector string relative to the element.
     * Corresponds to `element.querySelectorAll(selectors)`.
     */
    fun querySelectorAll(selectors: JsString): JsNodeList =
        JsNodeList.syntax(ChainOperation(this, InvocationOperation("querySelectorAll", selectors)))

    fun querySelectorAll(selectors: String): JsNodeList = querySelectorAll(selectors.js)

    /**
     * Returns the closest ancestor of the current element (or the element itself) which matches the selectors.
     * Corresponds to `element.closest(selectors)`.
     */
    fun closest(selectors: JsString): JsDomElement =
        JsDomElement.syntax(ChainOperation(this, InvocationOperation("closest", selectors)))

    fun closest(selectors: String): JsDomElement = closest(selectors.js)

    /**
     * Checks if the Element would be selected by the specified CSS selector.
     * Corresponds to `element.matches(selectors)`.
     */
    fun matches(selectors: JsString): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("matches", selectors)))

    fun matches(selectors: String): JsBoolean = matches(selectors.js)

    /**
     * Inserts a set of [JsNode] objects or strings after the last child of the element.
     * Corresponds to `element.append(nodes)`.
     */
    fun append(vararg nodes: JsDomElement): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("append", *nodes)))

    /**
     * Inserts a set of [JsNode] objects or strings before the first child of the element.
     * Corresponds to `element.prepend(nodes)`.
     */
    fun prepend(vararg nodes: JsNode): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("prepend", *nodes)))

    /**
     * Inserts a set of [JsNode] objects or strings in the children list of the element's parent, just before the element.
     * Corresponds to `element.before(nodes)`.
     */
    fun before(vararg nodes: JsNode): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("before", *nodes)))

    /**
     * Inserts a set of [JsNode] objects or strings in the children list of the element's parent, just after the element.
     * Corresponds to `element.after(nodes)`.
     */
    fun after(vararg nodes: JsNode): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("after", *nodes)))

    /**
     * Replaces the element in the children list of its parent with a set of [JsNode] objects or strings.
     * Corresponds to `element.replaceWith(nodes)`.
     */
    fun replaceWith(vararg nodes: JsDomElement): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("replaceWith", *nodes)))

    /**
     * Replaces the existing children of a Node with a specified new set of children.
     */
    fun replaceChildren(vararg nodes: JsDomElement): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("replaceChildren", *nodes)))

    /**
     * Scrolls the page until the element gets into view.
     * Corresponds to `element.scrollIntoView(alignToTop)`.
     */
    fun scrollIntoView(alignToTop: JsBoolean = true.js): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("scrollIntoView", alignToTop)))

    /**
     * Scrolls to a particular set of coordinates inside the element.
     * Corresponds to `element.scroll(x, y)` or `element.scroll({options})`.
     */
    fun scroll(x: JsNumber, y: JsNumber): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("scroll", x, y)))

    /**
     * Scrolls an element by the given amount.
     * Corresponds to `element.scrollBy(x, y)`.
     */
    fun scrollBy(x: JsNumber, y: JsNumber): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("scrollBy", x, y)))


    /**
     * Returns the size of an element and its position relative to the viewport.
     * Corresponds to `element.getBoundingClientRect()`. (Returns DOMRect).
     */
    fun getBoundingClientRect(): JsObject = JsObject.syntax(ChainOperation(this, InvocationOperation("getBoundingClientRect")))

    /**
     * A shortcut method to create and run an animation on an element. Returns the created Animation object instance.
     */
    fun animate(keyframes: JsObject, options: JsObject): JsObject = JsObject.syntax(ChainOperation(this, InvocationOperation("animate", keyframes, options)))

    /**
     * Attaches a shadow DOM tree to the specified element and returns a reference to its ShadowRoot.
     */
    fun attachShadow(options: JsObject): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("attachShadow", options)))

    /**
     * Returns whether an element is expected to be visible or not based on configurable checks.
     */
    fun checkVisibility(options: JsObject): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("checkVisibility", options)))

    /**
     * Returns an array of Animation objects currently active on the element.
     */
    fun getAnimations(options: JsObject): JsArray<JsObject> = JsArray.syntax(ChainOperation(this, InvocationOperation("getAnimations", options)))

    /**
     * Returns an array of Animation objects currently active on the element.
     */
    fun getAnimations(): JsArray<JsObject> = JsArray.syntax(ChainOperation(this, InvocationOperation("getAnimations")))

    /**
     * Returns the DOM content of the element as an HTML string, optionally including any shadow DOM.
     */
    fun getHTML(): JsDomElement = JsDomElement.syntax(ChainOperation(this, InvocationOperation("getHTML")))

    /**
     * Removes the element from the children list of its parent.
     */
    fun remove(): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("remove")))

    /**
     * Asynchronously asks the browser to make the element fullscreen.
     */
    fun requestFullScreen(): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("requestFullScreen")))

    /**
     * Asynchronously asks the browser to make the element fullscreen.
     */
    fun requestFullScreen(options: JsObject): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("requestFullScreen", options)))

    /**
     * Allows to asynchronously ask for the pointer to be locked on the given element.
     */
    fun requestPointerLock(): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("requestPointerLock")))

    /**
     * Allows to asynchronously ask for the pointer to be locked on the given element.
     */
    fun requestPointerLock(options: JsObject): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("requestPointerLock", options)))

    /**
     * Parses and sanitizes a string of HTML into a document fragment, which then replaces the element's original subtree in the DOM.
     */
    fun setHTML(input: JsString): JsNothing = JsNothing.syntax(ChainOperation(this, InvocationOperation("setHTML", input)))



    companion object
}