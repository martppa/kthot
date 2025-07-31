package net.asere.kotlin.js.dsl.dom.type.media.device

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaDevicesSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMediaDevices>(value),
    JsMediaDevices {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaDevices.Companion.syntax(value: String): JsMediaDevicesSyntax = JsMediaDevicesSyntax(value)
fun JsMediaDevices.Companion.syntax(value: JsElement): JsMediaDevicesSyntax = JsMediaDevicesSyntax(value)