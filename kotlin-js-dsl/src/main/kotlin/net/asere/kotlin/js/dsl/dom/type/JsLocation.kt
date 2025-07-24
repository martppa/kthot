package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js

interface JsLocation : JsObject {
    fun getHref(): JsStringSyntax = JsStringSyntax("${this}.href")
    fun setHref(url: JsString): JsSyntax = JsSyntax("${this}.href = $url")
    fun setHref(url: String): JsSyntax = setHref(url.js)
    fun getHostname(): JsStringSyntax = JsStringSyntax("${this}.hostname")
    fun getPathname(): JsStringSyntax = JsStringSyntax("${this}.pathname")
    fun getSearch(): JsStringSyntax = JsStringSyntax("${this}.search")
    fun getHash(): JsStringSyntax = JsStringSyntax("${this}.hash")
    fun getPort(): JsStringSyntax = JsStringSyntax("${this}.port")
    fun getProtocol(): JsStringSyntax = JsStringSyntax("${this}.protocol")
    fun assign(url: JsString): JsSyntax = JsSyntax("${this}.assign($url)")
    fun assign(url: String): JsSyntax = assign(url.js)
    fun reload(): JsSyntax = JsSyntax("${this}.reload()")
}