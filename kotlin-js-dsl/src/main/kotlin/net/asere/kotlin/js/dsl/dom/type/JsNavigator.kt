package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsObject

interface JsNavigator : JsObject {
    fun getUserAgent(): JsStringSyntax = JsStringSyntax("${this}.userAgent")
    fun getPlatform(): JsStringSyntax = JsStringSyntax("${this}.platform")
    fun getLanguage(): JsStringSyntax = JsStringSyntax("${this}.language")
    fun getOnline(): JsBooleanSyntax = JsBooleanSyntax("${this}.onLine")
    fun getCookieEnabled(): JsBooleanSyntax = JsBooleanSyntax("${this}.cookieEnabled")
}