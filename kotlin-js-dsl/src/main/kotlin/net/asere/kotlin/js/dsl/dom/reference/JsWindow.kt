package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.*
import net.asere.kotlin.js.dsl.dom.type.event.JsDomEvent
import net.asere.kotlin.js.dsl.types.reference.JsObjectRef
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1

object jsWindow : JsObjectRef("window"), JsWindow

interface JsWindow : JsObject {
    fun alert(text: JsString): JsSyntax = JsSyntax("${this}.alert($text)")
    fun alert(text: String): JsSyntax = alert(text.js)

    fun confirm(text: JsString): JsBooleanSyntax = JsBooleanSyntax("${this}.confirm($text)")
    fun confirm(text: String): JsBooleanSyntax = confirm(text.js)

    fun prompt(text: JsString, defaultValue: JsString? = null): JsStringSyntax =
        JsStringSyntax("${this}.prompt($text${defaultValue?.let { ", $it" } ?: ""})")
    fun prompt(text: String, defaultValue: String? = null): JsStringSyntax =
        prompt(text.js, defaultValue?.js)

    fun setTimeout(handler: JsLambda, delay: JsNumber): JsNumberSyntax = JsNumberSyntax("${this}.setTimeout($handler, $delay)")
    fun setTimeout(handler: JsLambda, delay: Int): JsNumberSyntax = setTimeout(handler, delay.js)

    fun clearTimeout(timeoutId: JsNumber): JsSyntax = JsSyntax("${this}.clearTimeout($timeoutId)")
    fun clearTimeout(timeoutId: Int): JsSyntax = clearTimeout(timeoutId.js)

    fun setInterval(handler: JsLambda, delay: JsNumber): JsNumberSyntax = JsNumberSyntax("${this}.setInterval($handler, $delay)")
    fun setInterval(handler: JsLambda, delay: Int): JsNumberSyntax = setInterval(handler, delay.js)

    fun clearInterval(intervalId: JsNumber): JsSyntax = JsSyntax("${this}.clearInterval($intervalId)")
    fun clearInterval(intervalId: Int): JsSyntax = clearInterval(intervalId.js)

    // --- Window Dimensions & Scrolling ---
    fun getInnerWidth(): JsNumberSyntax = JsNumberSyntax("${this}.innerWidth")
    fun getInnerHeight(): JsNumberSyntax = JsNumberSyntax("${this}.innerHeight")
    fun getOuterWidth(): JsNumberSyntax = JsNumberSyntax("${this}.outerWidth")
    fun getOuterHeight(): JsNumberSyntax = JsNumberSyntax("${this}.outerHeight")

    fun getScrollX(): JsNumberSyntax = JsNumberSyntax("${this}.scrollX")
    fun getScrollY(): JsNumberSyntax = JsNumberSyntax("${this}.scrollY")

    fun scrollTo(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax("${this}.scrollTo($x, $y)")
    fun scrollTo(x: Int, y: Int): JsSyntax = scrollTo(x.js, y.js)
    fun scrollBy(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax("${this}.scrollBy($x, $y)")
    fun scrollBy(x: Int, y: Int): JsSyntax = scrollBy(x.js, y.js)

    fun getName(): JsStringSyntax = JsStringSyntax("${this}.name")
    fun setName(name: JsString): JsSyntax = JsSyntax("${this}.name = $name")
    fun setName(name: String): JsSyntax = setName(name.js)

    fun getClosed(): JsBooleanSyntax = JsBooleanSyntax("${this}.closed")
    fun close(): JsSyntax = JsSyntax("${this}.close()")

    fun open(url: JsString? = null, windowName: JsString? = null, features: JsString? = null): JsSyntax =
        JsSyntax("${this}.open(${url?.let { "$it" } ?: "''"}${windowName?.let { ", $it" } ?: ""}${features?.let { ", $it" } ?: ""})")
    fun open(url: String? = null, windowName: String? = null, features: String? = null): JsSyntax =
        open(url?.js, windowName?.js, features?.js)

    fun print(): JsSyntax = JsSyntax("${this}.print()")

    // --- Navigation Objects (as properties) ---
    val location: JsLocation
        get() = object : JsLocation, JsObjectSyntax("${this}.location") {}

    val document: JsDomObject
        get() = object : JsDomObject, JsObjectSyntax("${this}.document") {}

    val history: JsHistory
        get() = object : JsHistory, JsObjectSyntax("${this}.history") {}

    val navigator: JsNavigator
        get() = object : JsNavigator, JsObjectSyntax("${this}.navigator") {}

    val screen: JsScreen
        get() = object : JsScreen, JsObjectSyntax("${this}.screen") {}

    fun addEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax = JsSyntax("${this}.addEventListener($event, $handler)")
    fun addEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = addEventListener(event.js, handler)

    fun removeEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax = JsSyntax("${this}.removeEventListener($event, $handler)")
    fun removeEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = removeEventListener(event.js, handler)
}