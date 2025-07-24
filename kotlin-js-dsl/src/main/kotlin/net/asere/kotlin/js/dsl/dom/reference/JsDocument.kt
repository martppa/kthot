package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsStringValue

object JsDocument : JsDomObjectRef("document") {
    fun getElementById(id: JsStringValue): JsSyntax = JsSyntax("${this}.getElementById($id)")
    fun querySelector(selector: JsStringValue): JsSyntax = JsSyntax("${this}.querySelector($selector)")
    fun querySelectorAll(selector: JsStringValue): JsSyntax = JsSyntax("${this}.querySelectorAll($selector)")
    fun getElementsByClassName(className: JsStringValue): JsSyntax = JsSyntax("${this}.getElementsByClassName($className)")
    fun getElementsByTagName(tagName: JsStringValue): JsSyntax = JsSyntax("${this}.getElementsByTagName($tagName)")
    fun getElementsByName(name: JsStringValue): JsSyntax = JsSyntax("${this}.getElementsByName($name)")
    fun createElement(tagName: JsStringValue): JsSyntax = JsSyntax("${this}.createElement($tagName)")
    fun createTextNode(text: JsStringValue): JsSyntax = JsSyntax("${this}.createTextNode($text)")
    fun createComment(text: JsStringValue): JsSyntax = JsSyntax("${this}.createComment($text)")
    fun createDocumentFragment(): JsSyntax = JsSyntax("${this}.createDocumentFragment()")
}