package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.dom.reference.JsDomObjectRef
import net.asere.kotlin.js.dsl.reference.JsLambda1Ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomCollectionSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.JsValue

interface JsDomObject : JsValue {
    fun getInnerHTML(): JsStringSyntax = JsStringSyntax("${this}.innerHTML")
    fun setInnerHTML(html: JsString): JsSyntax = JsSyntax("${this}.innerHTML = $html")
    fun setInnerHTML(html: String): JsSyntax = setInnerHTML(html.js)

    fun getTextContent(): JsStringSyntax = JsStringSyntax("${this}.textContent")
    fun setTextContent(text: JsString): JsSyntax = JsSyntax("${this}.textContent = $text")
    fun setTextContent(text: String): JsSyntax = setTextContent(text.js)

    fun appendChild(child: JsDomObject): JsDomObjectSyntax = JsDomObjectSyntax("${this}.appendChild($child)")
    fun removeChild(child: JsDomObject): JsDomObjectSyntax = JsDomObjectSyntax("${this}.removeChild($child)")
    fun replaceChild(newChild: JsDomObject, oldChild: JsDomObject): JsDomObjectSyntax = JsDomObjectSyntax("${this}.replaceChild($newChild, $oldChild)")
    fun insertBefore(newNode: JsDomObject, referenceNode: JsDomObject?): JsDomObjectSyntax = JsDomObjectSyntax("${this}.insertBefore($newNode, $referenceNode)")
    fun remove(): JsSyntax = JsSyntax("${this}.remove()")

    fun classListAdd(className: JsString): JsSyntax = JsSyntax("${this}.classList.add($className)")
    fun classListAdd(className: String): JsSyntax = classListAdd(className.js)
    fun classListRemove(className: JsString): JsSyntax = JsSyntax("${this}.classList.remove($className)")
    fun classListRemove(className: String): JsSyntax = classListRemove(className.js)
    fun classListToggle(className: JsString): JsSyntax = JsSyntax("${this}.classList.toggle($className)")
    fun classListToggle(className: String): JsSyntax = classListToggle(className.js)
    fun classListContains(className: JsString): JsBooleanSyntax = JsBooleanSyntax("${this}.classList.contains($className)") // Returns boolean
    fun classListContains(className: String): JsBooleanSyntax = classListContains(className.js)

    fun getAttribute(name: JsString): JsStringSyntax = JsStringSyntax("${this}.getAttribute($name)")
    fun getAttribute(name: String): JsStringSyntax = getAttribute(name.js)

    fun setAttribute(name: JsString, value: JsString): JsSyntax = JsSyntax("${this}.setAttribute($name, $value)")
    fun setAttribute(name: String, value: String): JsSyntax = setAttribute(name.js, value.js)
    fun setAttribute(name: String, value: JsString): JsSyntax = setAttribute(name.js, value)

    fun hasAttribute(name: JsString): JsBooleanSyntax = JsBooleanSyntax("${this}.hasAttribute($name)")
    fun hasAttribute(name: String): JsBooleanSyntax = hasAttribute(name.js)

    fun removeAttribute(name: JsString): JsSyntax = JsSyntax("${this}.removeAttribute($name)")
    fun removeAttribute(name: String): JsSyntax = removeAttribute(name.js)

    fun addEventListener(event: JsString, handler: JsLambda1Ref<JsDomObject>): JsSyntax = JsSyntax("${this}.addEventListener($event, $handler)")
    fun addEventListener(event: String, handler: JsLambda1Ref<JsDomObject>): JsSyntax = addEventListener(event.js, handler)

    fun removeEventListener(event: JsString, handler: JsLambda1Ref<JsDomObject>): JsSyntax = JsSyntax("${this}.removeEventListener($event, $handler)")
    fun removeEventListener(event: String, handler: JsLambda1Ref<JsDomObject>): JsSyntax = removeEventListener(event.js, handler)

    fun getId(): JsStringSyntax = JsStringSyntax("${this}.id")
    fun setId(id: JsString): JsSyntax = JsSyntax("${this}.id = $id")
    fun setId(id: String): JsSyntax = setId(id.js)

    fun getClassName(): JsStringSyntax = JsStringSyntax("${this}.className")
    fun setClassName(className: JsString): JsSyntax = JsSyntax("${this}.className = $className")
    fun setClassName(className: String): JsSyntax = setClassName(className.js)

    fun getTagName(): JsStringSyntax = JsStringSyntax("${this}.tagName")

    fun getParentNode(): JsDomObjectSyntax = JsDomObjectSyntax("${this}.parentNode")
    fun getParentElement(): JsDomObjectSyntax = JsDomObjectSyntax("${this}.parentElement")

    fun getChildren(): JsDomCollectionSyntax = JsDomCollectionSyntax("${this}.children")
    fun getFirstElementChild(): JsDomObjectSyntax = JsDomObjectSyntax("${this}.firstElementChild")
    fun getLastElementChild(): JsDomObjectSyntax = JsDomObjectSyntax("${this}.lastElementChild")
    fun getNextElementSibling(): JsDomObjectSyntax = JsDomObjectSyntax("${this}.nextElementSibling")
    fun getPreviousElementSibling(): JsDomObjectSyntax = JsDomObjectSyntax("${this}.previousElementSibling")

    fun getStyle(propertyName: JsString): JsStringSyntax = JsStringSyntax("${this}.style[$propertyName]")
    fun getStyle(propertyName: String): JsStringSyntax = getStyle(propertyName.js)

    fun setStyle(propertyName: JsString, value: JsString): JsSyntax = JsSyntax("${this}.style[$propertyName] = $value")
    fun setStyle(propertyName: String, value: String): JsSyntax = setStyle(propertyName.js, value.js)
    fun setStyle(propertyName: String, value: JsString): JsSyntax = setStyle(propertyName.js, value)

    fun querySelector(selector: JsString): JsDomObjectSyntax = JsDomObjectSyntax("${this}.querySelector($selector)")
    fun querySelector(selector: String): JsDomObjectSyntax = querySelector(selector.js)

    fun querySelectorAll(selector: JsString): JsDomCollectionSyntax = JsDomCollectionSyntax("${this}.querySelectorAll($selector)")
    fun querySelectorAll(selector: String): JsDomCollectionSyntax = querySelectorAll(selector.js)

    companion object
}

fun JsDomObject.Companion.ref(name: String? = null) = JsDomObjectRef(name)

