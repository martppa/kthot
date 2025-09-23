package net.asere.kotlin.js.dsl.dom.type.data.obj

import net.asere.kotlin.js.dsl.dom.type.data.array.JsDomArray
import net.asere.kotlin.js.dsl.dom.type.data.array.JsDomArraySyntax
import net.asere.kotlin.js.dsl.dom.type.data.array.syntax
import net.asere.kotlin.js.dsl.dom.type.data.event.dom.JsDomEvent
import net.asere.kotlin.js.dsl.dom.type.data.token.list.JsDomTokenList
import net.asere.kotlin.js.dsl.dom.type.data.token.list.syntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.AccessOperation
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.AssignmentOperation
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.string.syntax
import net.asere.kotlin.js.dsl.type.Undefined
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript DOM Element object. This interface provides methods and properties
 * for interacting with HTML elements in the Document Object Model.
 */
interface JsDomObject : JsValue {

    /**
     * Returns the HTML content (markup and text) inside the element as a [JsString] object.
     *
     * In JavaScript, this corresponds to `element.innerHTML`.
     */
    val innerHTML: JsString get() = JsString.syntax(ChainOperation(this, "innerHTML"))

    /**
     * Sets the HTML content inside the element.
     *
     * In JavaScript, this corresponds to `element.innerHTML = html`.
     * @param html The new HTML content as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setInnerHTML(html: JsString): JsSyntax = JsSyntax("${ChainOperation(this, "innerHTML")} = $html")

    /**
     * Sets the HTML content inside the element.
     * This is a convenience overload for [setInnerHTML] that accepts a Kotlin [String].
     *
     * @param html The new HTML content as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setInnerHTML(html: String): JsSyntax = setInnerHTML(html.js)

    /**
     * Returns the text content of the element and its descendants, without HTML markup,
     * as a [JsString] object.
     *
     * In JavaScript, this corresponds to `element.textContent`.
     */
    val textContent: JsString get() = JsString.syntax(ChainOperation(this, "textContent"))

    /**
     * Sets the text content of the element, replacing any existing children.
     *
     * In JavaScript, this corresponds to `element.textContent = text`.
     * @param text The new text content as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setTextContent(text: JsString): JsSyntax =
        AssignmentOperation(ChainOperation(this, "textContent"), text)

    /**
     * Sets the text content of the element, replacing any existing children.
     * This is a convenience overload for [setTextContent] that accepts a Kotlin [String].
     *
     * @param text The new text content as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setTextContent(text: String): JsSyntax = setTextContent(text.js)

    /**
     * Appends a child [JsDomObject] to the current element.
     *
     * In JavaScript, this corresponds to `element.appendChild(child)`.
     * @param child The [JsDomObject] to append.
     * @return A [JsDomObject] representing the appended child (for chaining).
     */
    fun appendChild(child: JsDomObject): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("appendChild", child)))

    /**
     * Removes a specified child [JsDomObject] from the current element.
     *
     * In JavaScript, this corresponds to `element.removeChild(child)`.
     * @param child The [JsDomObject] to remove.
     * @return A [JsDomObject] representing the removed child.
     */
    fun removeChild(child: JsDomObject): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("removeChild", child)))

    /**
     * Replaces an existing child [JsDomObject] with a new one.
     *
     * In JavaScript, this corresponds to `element.replaceChild(newChild, oldChild)`.
     * @param newChild The new [JsDomObject] to insert.
     * @param oldChild The existing [JsDomObject] to replace.
     * @return A [JsDomObject] representing the replaced child.
     */
    fun replaceChild(newChild: JsDomObject, oldChild: JsDomObject): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("replaceChild", newChild, oldChild)))

    /**
     * Inserts a new child [JsDomObject] before a specified reference child.
     * If `referenceNode` is `null`, `newNode` is appended to the list of children.
     *
     * In JavaScript, this corresponds to `element.insertBefore(newNode, referenceNode)`.
     * @param newNode The new [JsDomObject] to insert.
     * @param referenceNode The existing [JsDomObject] before which `newNode` will be inserted, or `null`.
     * @return A [JsDomObject] representing the inserted node.
     */
    fun insertBefore(newNode: JsDomObject, referenceNode: JsDomObject? = null): JsDomObject =
        JsDomObject.syntax(
            ChainOperation(
                this,
                InvocationOperation("insertBefore", newNode, referenceNode ?: Undefined)
            )
        )

    /**
     * Removes the element from the DOM tree it belongs to.
     *
     * In JavaScript, this corresponds to `element.remove()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun remove(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("remove")))

    /**
     * Returns the `DOMTokenList` object for the element's `class` attribute.
     * This allows for convenient manipulation of individual class names.
     *
     * In JavaScript, this corresponds to `element.classList`.
     */
    val classList: JsDomTokenList
        get(): JsDomTokenList = JsDomTokenList.syntax(
            ChainOperation(
                this,
                "classList"
            )
        )

    /**
     * Returns the value of a specified attribute on the element as a [JsString] object.
     * Returns `null` if the attribute does not exist.
     *
     * In JavaScript, this corresponds to `element.getAttribute(name)`.
     * @param name The name of the attribute to retrieve as a [JsString] object.
     * @return A [JsString] object representing the attribute's value.
     */
    fun getAttribute(name: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("getAttribute", name)))

    /**
     * Returns the value of a specified attribute on the element.
     * This is a convenience overload for [getAttribute] that accepts a Kotlin [String].
     *
     * @param name The name of the attribute to retrieve as a Kotlin [String].
     * @return A [JsString] object representing the attribute's value.
     */
    fun getAttribute(name: String): JsString = getAttribute(name.js)

    /**
     * Sets the value of a specified attribute on the element. If the attribute already exists,
     * its value is updated; otherwise, a new attribute is added.
     *
     * In JavaScript, this corresponds to `element.setAttribute(name, value)`.
     * @param name The name of the attribute to set as a [JsString] object.
     * @param value The value to set the attribute to as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun setAttribute(name: JsString, value: JsString): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("setAttribute", name, value)))

    /**
     * Sets the value of a specified attribute on the element.
     * This is a convenience overload for [setAttribute] that accepts Kotlin [String]s.
     *
     * @param name The name of the attribute to set as a Kotlin [String].
     * @param value The value to set the attribute to as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun setAttribute(name: String, value: String): JsSyntax = setAttribute(name.js, value.js)

    /**
     * Sets the value of a specified attribute on the element.
     * This is a convenience overload for [setAttribute] that accepts a Kotlin [String] for name
     * and a [JsString] for value.
     *
     * @param name The name of the attribute to set as a Kotlin [String].
     * @param value The value to set the attribute to as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun setAttribute(name: String, value: JsString): JsSyntax = setAttribute(name.js, value)

    /**
     * Checks if the element has a specified attribute.
     *
     * In JavaScript, this corresponds to `element.hasAttribute(name)`.
     * @param name The name of the attribute to check for as a [JsString] object.
     * @return A [JsBoolean] object representing the JavaScript boolean result.
     */
    fun hasAttribute(name: JsString): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("hasAttribute", name)))

    /**
     * Checks if the element has a specified attribute.
     * This is a convenience overload for [hasAttribute] that accepts a Kotlin [String].
     *
     * @param name The name of the attribute to check for as a Kotlin [String].
     * @return A [JsBoolean] object representing the JavaScript boolean result.
     */
    fun hasAttribute(name: String): JsBoolean = hasAttribute(name.js)

    /**
     * Removes a specified attribute from the element.
     *
     * In JavaScript, this corresponds to `element.removeAttribute(name)`.
     * @param name The name of the attribute to remove as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeAttribute(name: JsString): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("removeAttribute", name)))

    /**
     * Removes a specified attribute from the element.
     * This is a convenience overload for [removeAttribute] that accepts a Kotlin [String].
     *
     * @param name The name of the attribute to remove as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeAttribute(name: String): JsSyntax = removeAttribute(name.js)

    /**
     * Attaches an event listener to the element. When the specified event occurs,
     * the provided handler function will be executed.
     *
     * In JavaScript, this corresponds to `element.addEventListener(event, handler)`.
     * @param event The name of the event to listen for (e.g., "click", "mouseover") as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function to execute when the event occurs.
     * The function typically receives a [JsDomEvent] object as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("addEventListener", event, handler)))

    /**
     * Attaches an event listener to the element.
     * This is a convenience overload for [addEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event to listen for as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function to execute.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = addEventListener(event.js, handler)

    /**
     * Removes an event listener from the element.
     * The `handler` function must be the *exact same function instance* that was originally added.
     *
     * In JavaScript, this corresponds to `element.removeEventListener(event, handler)`.
     * @param event The name of the event as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("removeEventListener", event, handler)))

    /**
     * Removes an event listener from the element.
     * This is a convenience overload for [removeEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax =
        removeEventListener(event.js, handler)

    /**
     * Returns the `id` attribute of the element as a [JsString] object.
     *
     * In JavaScript, this corresponds to `element.id`.
     */
    val id: JsString get() = JsString.syntax(ChainOperation(this, "id"))

    /**
     * Sets the `id` attribute of the element.
     *
     * In JavaScript, this corresponds to `element.id = id`.
     * @param id The new `id` as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setId(id: JsString): JsSyntax = JsSyntax("${ChainOperation(this, "id")} = $id")

    /**
     * Sets the `id` attribute of the element.
     * This is a convenience overload for [setId] that accepts a Kotlin [String].
     *
     * @param id The new `id` as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setId(id: String): JsSyntax = setId(id.js)

    /**
     * Returns the `className` attribute of the element as a [JsString] object.
     * This represents the space-separated list of classes. For more robust class manipulation,
     * use `classListAdd`, `classListRemove`, etc.
     *
     * In JavaScript, this corresponds to `element.className`.
     */
    val className: JsString get() = JsString.syntax(ChainOperation(this, "className"))

    /**
     * Sets the `className` attribute of the element. This will overwrite all existing classes.
     *
     * In JavaScript, this corresponds to `element.className = className`.
     * @param className The new class string as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setClassName(className: JsString): JsSyntax =
        JsSyntax("${ChainOperation(this, "className")} = $className")

    /**
     * Sets the `className` attribute of the element.
     * This is a convenience overload for [setClassName] that accepts a Kotlin [String].
     *
     * @param className The new class string as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setClassName(className: String): JsSyntax = setClassName(className.js)

    /**
     * Returns the tag name of the element (e.g., "DIV", "SPAN") as a [JsString] object.
     * The tag name is always in uppercase.
     *
     * In JavaScript, this corresponds to `element.tagName`.
     */
    val tagName: JsString get() = JsString.syntax(ChainOperation(this, "tagName"))

    /**
     * Returns the parent `Node` of the current element as a [JsDomObject] object.
     * This can be an `Element`, `Document`, or `DocumentFragment`.
     *
     * In JavaScript, this corresponds to `element.parentNode`.
     */
    val parentNode: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "parentNode"))

    /**
     * Returns the parent `Element` of the current element as a [JsDomObject] object.
     * This will be `null` if the parent is not an element (e.g., `document`).
     *
     * In JavaScript, this corresponds to `element.parentElement`.
     */
    val parentElement: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "parentElement"))

    /**
     * Returns a live `HTMLCollection` of the child elements of the current element
     * as a [JsDomArraySyntax] object.
     *
     * In JavaScript, this corresponds to `element.children`.
     */
    val children: JsDomArray get() = JsDomArray.syntax(ChainOperation(this, "children"))

    /**
     * Returns the first child `Element` of the current element as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `element.firstElementChild`.
     */
    val firstElementChild: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "firstElementChild"))

    /**
     * Returns the last child `Element` of the current element as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `element.lastElementChild`.
     */
    val lastElementChild: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "lastElementChild"))

    /**
     * Returns the next sibling `Element` of the current element as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `element.nextElementSibling`.
     */
    val nextElementSibling: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "nextElementSibling"))

    /**
     * Returns the previous sibling `Element` of the current element as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `element.previousElementSibling`.
     */
    val previousElementSibling: JsDomObject
        get() = JsDomObject.syntax(
            ChainOperation(
                this,
                "previousElementSibling"
            )
        )

    /**
     * Returns the value of a specific inline CSS style property of the element as a [JsString] object.
     *
     * In JavaScript, this corresponds to `element.style.propertyName`.
     * @param propertyName The CSS property name (e.g., "backgroundColor", "width") as a [JsString] object.
     * @return A [JsString] object representing the style value.
     */
    fun getStyle(propertyName: JsString): JsString =
        JsString.syntax(ChainOperation(this, AccessOperation("style", propertyName)))

    /**
     * Returns the value of a specific inline CSS style property of the element.
     * This is a convenience overload for [getStyle] that accepts a Kotlin [String].
     *
     * @param propertyName The CSS property name as a Kotlin [String].
     * @return A [JsString] object representing the style value.
     */
    fun getStyle(propertyName: String): JsString = getStyle(propertyName.js)

    /**
     * Sets the value of a specific inline CSS style property of the element.
     *
     * In JavaScript, this corresponds to `element.style.propertyName = value`.
     * @param propertyName The CSS property name as a [JsString] object.
     * @param value The value to set the style property to as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setStyle(propertyName: JsString, value: JsString): JsSyntax =
        JsSyntax("${ChainOperation(this, AccessOperation("style", propertyName))} = $value")

    /**
     * Sets the value of a specific inline CSS style property of the element.
     * This is a convenience overload for [setStyle] that accepts Kotlin [String]s.
     *
     * @param propertyName The CSS property name as a Kotlin [String].
     * @param value The value to set the style property to as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setStyle(propertyName: String, value: String): JsSyntax = setStyle(propertyName.js, value.js)

    /**
     * Sets the value of a specific inline CSS style property of the element.
     * This is a convenience overload for [setStyle] that accepts a Kotlin [String] for property name
     * and a [JsString] for value.
     *
     * @param propertyName The CSS property name as a Kotlin [String].
     * @param value The value to set the style property to as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setStyle(propertyName: String, value: JsString): JsSyntax = setStyle(propertyName.js, value)

    /**
     * Returns the first `Element` within the document that matches the specified CSS selector(s).
     *
     * In JavaScript, this corresponds to `element.querySelector(selector)`.
     * @param selector A [JsString] object containing one or more CSS selectors to match.
     * @return A [JsDomObject] representing the first matching element, or `null` if no match is found.
     */
    fun querySelector(selector: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("querySelector", selector)))

    /**
     * Returns the first `Element` within the document that matches the specified CSS selector(s).
     * This is a convenience overload for [querySelector] that accepts a Kotlin [String].
     *
     * @param selector A Kotlin [String] containing one or more CSS selectors to match.
     * @return A [JsDomObject] representing the first matching element, or `null` if no match is found.
     */
    fun querySelector(selector: String): JsDomObject = querySelector(selector.js)

    /**
     * Returns a `NodeList` (a static `JsDomCollection`) of all elements within the document
     * that match the specified CSS selector(s).
     *
     * In JavaScript, this corresponds to `element.querySelectorAll(selector)`.
     * @param selector A [JsString] object containing one or more CSS selectors to match.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun querySelectorAll(selector: JsString): JsDomArray =
        JsDomArray.syntax(ChainOperation(this, InvocationOperation("querySelectorAll", selector)))

    /**
     * Returns a `NodeList` (a static `JsDomCollection`) of all elements within the document
     * that match the specified CSS selector(s).
     * This is a convenience overload for [querySelectorAll] that accepts a Kotlin [String].
     *
     * @param selector A Kotlin [String] containing one or more CSS selectors to match.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun querySelectorAll(selector: String): JsDomArray = querySelectorAll(selector.js)

    companion object
}
