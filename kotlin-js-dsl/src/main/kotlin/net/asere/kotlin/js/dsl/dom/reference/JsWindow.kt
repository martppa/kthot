package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.*
import net.asere.kotlin.js.dsl.dom.type.event.JsDomEvent
import net.asere.kotlin.js.dsl.types.reference.JsObjectRef
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.*
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1

object Window : JsObjectRef("window") {
    fun alert(text: JsString): JsSyntax = JsSyntax("${this}.alert($text)")
    fun alert(text: String): JsSyntax = alert(text.js)

    fun confirm(text: JsString): JsBoolean = JsBooleanSyntax("${this}.confirm($text)")
    fun confirm(text: String): JsBoolean = confirm(text.js)

    fun prompt(text: JsString, defaultValue: JsString? = null): JsString =
        JsStringSyntax("${this}.prompt($text${defaultValue?.let { ", $it" } ?: ""})")
    fun prompt(text: String, defaultValue: String? = null): JsString =
        prompt(text.js, defaultValue?.js)

    fun setTimeout(handler: JsLambda, delay: JsNumber): JsNumber = JsNumberSyntax("${this}.setTimeout($handler, $delay)")
    fun setTimeout(handler: JsLambda, delay: Int): JsNumber = setTimeout(handler, delay.js)

    fun clearTimeout(timeoutId: JsNumber): JsSyntax = JsSyntax("${this}.clearTimeout($timeoutId)")
    fun clearTimeout(timeoutId: Int): JsSyntax = clearTimeout(timeoutId.js)

    fun setInterval(handler: JsLambda, delay: JsNumber): JsNumber = JsNumberSyntax("${this}.setInterval($handler, $delay)")
    fun setInterval(handler: JsLambda, delay: Int): JsNumber = setInterval(handler, delay.js)

    fun clearInterval(intervalId: JsNumber): JsSyntax = JsSyntax("${this}.clearInterval($intervalId)")
    fun clearInterval(intervalId: Int): JsSyntax = clearInterval(intervalId.js)

    fun getInnerWidth(): JsNumber = JsNumberSyntax("${this}.innerWidth")
    fun getInnerHeight(): JsNumber = JsNumberSyntax("${this}.innerHeight")
    fun getOuterWidth(): JsNumber = JsNumberSyntax("${this}.outerWidth")
    fun getOuterHeight(): JsNumber = JsNumberSyntax("${this}.outerHeight")

    fun getScrollX(): JsNumber = JsNumberSyntax("${this}.scrollX")
    fun getScrollY(): JsNumber = JsNumberSyntax("${this}.scrollY")

    fun scrollTo(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax("${this}.scrollTo($x, $y)")
    fun scrollTo(x: Int, y: Int): JsSyntax = scrollTo(x.js, y.js)
    fun scrollBy(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax("${this}.scrollBy($x, $y)")
    fun scrollBy(x: Int, y: Int): JsSyntax = scrollBy(x.js, y.js)

    fun getName(): JsString = JsStringSyntax("${this}.name")
    fun setName(name: JsString): JsSyntax = JsSyntax("${this}.name = $name")
    fun setName(name: String): JsSyntax = setName(name.js)

    fun getClosed(): JsBoolean = JsBooleanSyntax("${this}.closed")
    fun close(): JsSyntax = JsSyntax("${this}.close()")

    fun open(url: JsString? = null, windowName: JsString? = null, features: JsString? = null): JsSyntax =
        JsSyntax("${this}.open(${url?.let { "$it" } ?: "''"}${windowName?.let { ", $it" } ?: ""}${features?.let { ", $it" } ?: ""})")
    fun open(url: String? = null, windowName: String? = null, features: String? = null): JsSyntax =
        open(url?.js, windowName?.js, features?.js)

    fun print(): JsSyntax = JsSyntax("${this}.print()")

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