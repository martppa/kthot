package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js

interface JsHistory : JsObject {
    fun getLength(): JsNumberSyntax = JsNumberSyntax("${this}.length")
    fun back(): JsSyntax = JsSyntax("${this}.back()")
    fun forward(): JsSyntax = JsSyntax("${this}.forward()")
    fun go(delta: JsNumber): JsSyntax = JsSyntax("${this}.go($delta)")
    fun go(delta: Int): JsSyntax = go(delta.js)
    fun pushState(state: JsSyntax, title: JsString, url: JsString? = null): JsSyntax = JsSyntax("${this}.pushState($state, $title${url?.let { ", $it" } ?: ""})")
    fun pushState(state: JsSyntax, title: String, url: String? = null): JsSyntax = pushState(state, title.js, url?.js)
    fun replaceState(state: JsSyntax, title: JsString, url: JsString? = null): JsSyntax = JsSyntax("${this}.replaceState($state, $title${url?.let { ", $it" } ?: ""})")
    fun replaceState(state: JsSyntax, title: String, url: String? = null): JsSyntax = replaceState(state, title.js, url?.js)
}