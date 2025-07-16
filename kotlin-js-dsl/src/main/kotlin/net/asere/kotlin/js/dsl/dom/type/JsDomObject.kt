package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsStringValue
import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsDomObject : JsValue {
    fun getInnerHTML(): JsSyntax = JsSyntax("${this}.innerHTML")
    fun setInnerHTML(html: JsStringValue): JsSyntax = JsSyntax("${this}.innerHTML = $html")
    fun getTextContent(): JsSyntax = JsSyntax("${this}.textContent")
    fun setTextContent(text: JsStringValue): JsSyntax = JsSyntax("${this}.setTextContent($text)")
    fun appendChild(child: JsReference<JsValue>): JsSyntax = JsSyntax("${this}.appendChild($child)")
    fun removeChild(child: JsSyntax): JsSyntax = JsSyntax("${this}.removeChild($child)")
    fun remove(): JsSyntax = JsSyntax("${this}.remove()")
    fun classListAdd(className: JsStringValue): JsSyntax = JsSyntax("${this}.classList.add($className)")
    fun classListRemove(className: JsStringValue): JsSyntax = JsSyntax("${this}.classList.remove($className)")
    fun classListToggle(className: JsStringValue): JsSyntax = JsSyntax("${this}.classList.toggle($className)")
    fun classListContains(className: JsStringValue): JsSyntax = JsSyntax("${this}.classList.contains($className)")
    override fun toString(): String = present()
}