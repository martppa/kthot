package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.dom.type.event.JsDomEvent
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomCollectionSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

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
    fun getInnerHTML(): JsString = JsStringSyntax("${this}.innerHTML")

    /**
     * Sets the HTML content inside the element.
     *
     * In JavaScript, this corresponds to `element.innerHTML = html`.
     * @param html The new HTML content as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setInnerHTML(html: JsString): JsSyntax = JsSyntax("${this}.innerHTML = $html")

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
    fun getTextContent(): JsString = JsStringSyntax("${this}.textContent")

    /**
     * Sets the text content of the element, replacing any existing children.
     *
     * In JavaScript, this corresponds to `element.textContent = text`.
     * @param text The new text content as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setTextContent(text: JsString): JsSyntax = JsSyntax("${this}.textContent = $text")

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
    fun appendChild(child: JsDomObject): JsDomObject = JsDomObjectSyntax("${this}.appendChild($child)")

    /**
     * Removes a specified child [JsDomObject] from the current element.
     *
     * In JavaScript, this corresponds to `element.removeChild(child)`.
     * @param child The [JsDomObject] to remove.
     * @return A [JsDomObject] representing the removed child.
     */
    fun removeChild(child: JsDomObject): JsDomObject = JsDomObjectSyntax("${this}.removeChild($child)")

    /**
     * Replaces an existing child [JsDomObject] with a new one.
     *
     * In JavaScript, this corresponds to `element.replaceChild(newChild, oldChild)`.
     * @param newChild The new [JsDomObject] to insert.
     * @param oldChild The existing [JsDomObject] to replace.
     * @return A [JsDomObject] representing the replaced child.
     */
    fun replaceChild(newChild: JsDomObject, oldChild: JsDomObject): JsDomObject = JsDomObjectSyntax("${this}.replaceChild($newChild, $oldChild)")

    /**
     * Inserts a new child [JsDomObject] before a specified reference child.
     * If `referenceNode` is `null`, `newNode` is appended to the list of children.
     *
     * In JavaScript, this corresponds to `element.insertBefore(newNode, referenceNode)`.
     * @param newNode The new [JsDomObject] to insert.
     * @param referenceNode The existing [JsDomObject] before which `newNode` will be inserted, or `null`.
     * @return A [JsDomObject] representing the inserted node.
     */
    fun insertBefore(newNode: JsDomObject, referenceNode: JsDomObject?): JsDomObject = JsDomObjectSyntax("${this}.insertBefore($newNode, $referenceNode)")

    /**
     * Removes the element from the DOM tree it belongs to.
     *
     * In JavaScript, this corresponds to `element.remove()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun remove(): JsSyntax = JsSyntax("${this}.remove()")

    /**
     * Adds one or more class names to the element's `classList`.
     *
     * In JavaScript, this corresponds to `element.classList.add(className)`.
     * @param className The class name to add as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun classListAdd(className: JsString): JsSyntax = JsSyntax("${this}.classList.add($className)")

    /**
     * Adds one or more class names to the element's `classList`.
     * This is a convenience overload for [classListAdd] that accepts a Kotlin [String].
     *
     * @param className The class name to add as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun classListAdd(className: String): JsSyntax = classListAdd(className.js)

    /**
     * Removes one or more class names from the element's `classList`.
     *
     * In JavaScript, this corresponds to `element.classList.remove(className)`.
     * @param className The class name to remove as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun classListRemove(className: JsString): JsSyntax = JsSyntax("${this}.classList.remove($className)")

    /**
     * Removes one or more class names from the element's `classList`.
     * This is a convenience overload for [classListRemove] that accepts a Kotlin [String].
     *
     * @param className The class name to remove as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun classListRemove(className: String): JsSyntax = classListRemove(className.js)

    /**
     * Toggles a class name on the element's `classList`. If the class exists, it's removed;
     * if it doesn't exist, it's added.
     *
     * In JavaScript, this corresponds to `element.classList.toggle(className)`.
     * @param className The class name to toggle as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun classListToggle(className: JsString): JsSyntax = JsSyntax("${this}.classList.toggle($className)")

    /**
     * Toggles a class name on the element's `classList`.
     * This is a convenience overload for [classListToggle] that accepts a Kotlin [String].
     *
     * @param className The class name to toggle as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun classListToggle(className: String): JsSyntax = classListToggle(className.js)

    /**
     * Checks if the element's `classList` contains a specific class name.
     *
     * In JavaScript, this corresponds to `element.classList.contains(className)`.
     * @param className The class name to check for as a [JsString] object.
     * @return A [JsBoolean] object representing the JavaScript boolean result.
     */
    fun classListContains(className: JsString): JsBoolean = JsBooleanSyntax("${this}.classList.contains($className)")

    /**
     * Checks if the element's `classList` contains a specific class name.
     * This is a convenience overload for [classListContains] that accepts a Kotlin [String].
     *
     * @param className The class name to check for as a Kotlin [String].
     * @return A [JsBoolean] object representing the JavaScript boolean result.
     */
    fun classListContains(className: String): JsBoolean = classListContains(className.js)

    /**
     * Returns the value of a specified attribute on the element as a [JsString] object.
     * Returns `null` if the attribute does not exist.
     *
     * In JavaScript, this corresponds to `element.getAttribute(name)`.
     * @param name The name of the attribute to retrieve as a [JsString] object.
     * @return A [JsString] object representing the attribute's value.
     */
    fun getAttribute(name: JsString): JsString = JsStringSyntax("${this}.getAttribute($name)")

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
    fun setAttribute(name: JsString, value: JsString): JsSyntax = JsSyntax("${this}.setAttribute($name, $value)")

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
    fun hasAttribute(name: JsString): JsBoolean = JsBooleanSyntax("${this}.hasAttribute($name)")

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
    fun removeAttribute(name: JsString): JsSyntax = JsSyntax("${this}.removeAttribute($name)")

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
    fun addEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax = JsSyntax("${this}.addEventListener($event, $handler)")

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
    fun removeEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax = JsSyntax("${this}.removeEventListener($event, $handler)")

    /**
     * Removes an event listener from the element.
     * This is a convenience overload for [removeEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = removeEventListener(event.js, handler)

    /**
     * Returns the `id` attribute of the element as a [JsString] object.
     *
     * In JavaScript, this corresponds to `element.id`.
     */
    fun getId(): JsString = JsStringSyntax("${this}.id")

    /**
     * Sets the `id` attribute of the element.
     *
     * In JavaScript, this corresponds to `element.id = id`.
     * @param id The new `id` as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setId(id: JsString): JsSyntax = JsSyntax("${this}.id = $id")

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
    fun getClassName(): JsString = JsStringSyntax("${this}.className")

    /**
     * Sets the `className` attribute of the element. This will overwrite all existing classes.
     *
     * In JavaScript, this corresponds to `element.className = className`.
     * @param className The new class string as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setClassName(className: JsString): JsSyntax = JsSyntax("${this}.className = $className")

    /**
     * Sets the `className` attribute of the element.
     * This is a convenience overload for [setClassName] that accepts a Kotlin [String].
     *
     * @param className The new class string as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setClassName(className: String): JsSyntax = setClassName(className.js)

    /**
     * Returns the tag name of the element (e.g., "DIV", "SPAN") as a [JsStringSyntax] object.
     * The tag name is always in uppercase.
     *
     * In JavaScript, this corresponds to `element.tagName`.
     */
    val tagName: JsStringSyntax get() = JsStringSyntax("${this}.tagName")

    // --- Parent/Sibling/Child Navigation Properties ---

    /**
     * Returns the parent `Node` of the current element as a [JsDomObjectSyntax] object.
     * This can be an `Element`, `Document`, or `DocumentFragment`.
     *
     * In JavaScript, this corresponds to `element.parentNode`.
     */
    val parentNode: JsDomObjectSyntax get() = JsDomObjectSyntax("${this}.parentNode")

    /**
     * Returns the parent `Element` of the current element as a [JsDomObjectSyntax] object.
     * This will be `null` if the parent is not an element (e.g., `document`).
     *
     * In JavaScript, this corresponds to `element.parentElement`.
     */
    val parentElement: JsDomObjectSyntax get() = JsDomObjectSyntax("${this}.parentElement")

    /**
     * Returns a live `HTMLCollection` of the child elements of the current element
     * as a [JsDomCollectionSyntax] object.
     *
     * In JavaScript, this corresponds to `element.children`.
     */
    val children: JsDomCollectionSyntax get() = JsDomCollectionSyntax("${this}.children")

    /**
     * Returns the first child `Element` of the current element as a [JsDomObjectSyntax] object.
     *
     * In JavaScript, this corresponds to `element.firstElementChild`.
     */
    val firstElementChild: JsDomObjectSyntax get() = JsDomObjectSyntax("${this}.firstElementChild")

    /**
     * Returns the last child `Element` of the current element as a [JsDomObjectSyntax] object.
     *
     * In JavaScript, this corresponds to `element.lastElementChild`.
     */
    val lastElementChild: JsDomObjectSyntax get() = JsDomObjectSyntax("${this}.lastElementChild")

    /**
     * Returns the next sibling `Element` of the current element as a [JsDomObjectSyntax] object.
     *
     * In JavaScript, this corresponds to `element.nextElementSibling`.
     */
    val nextElementSibling: JsDomObjectSyntax get() = JsDomObjectSyntax("${this}.nextElementSibling")

    /**
     * Returns the previous sibling `Element` of the current element as a [JsDomObjectSyntax] object.
     *
     * In JavaScript, this corresponds to `element.previousElementSibling`.
     */
    val previousElementSibling: JsDomObjectSyntax get() = JsDomObjectSyntax("${this}.previousElementSibling")

    /**
     * Returns the value of a specific inline CSS style property of the element as a [JsString] object.
     *
     * In JavaScript, this corresponds to `element.style.propertyName`.
     * @param propertyName The CSS property name (e.g., "backgroundColor", "width") as a [JsString] object.
     * @return A [JsString] object representing the style value.
     */
    fun getStyle(propertyName: JsString): JsString = JsStringSyntax("${this}.style[$propertyName]")

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
    fun setStyle(propertyName: JsString, value: JsString): JsSyntax = JsSyntax("${this}.style[$propertyName] = $value")

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
    fun querySelector(selector: JsString): JsDomObject = JsDomObjectSyntax("${this}.querySelector($selector)")

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
     * @return A [JsDomCollection] containing all matching elements.
     */
    fun querySelectorAll(selector: JsString): JsDomCollection = JsDomCollectionSyntax("${this}.querySelectorAll($selector)")

    /**
     * Returns a `NodeList` (a static `JsDomCollection`) of all elements within the document
     * that match the specified CSS selector(s).
     * This is a convenience overload for [querySelectorAll] that accepts a Kotlin [String].
     *
     * @param selector A Kotlin [String] containing one or more CSS selectors to match.
     * @return A [JsDomCollection] containing all matching elements.
     */
    fun querySelectorAll(selector: String): JsDomCollection = querySelectorAll(selector.js)

    companion object
}

