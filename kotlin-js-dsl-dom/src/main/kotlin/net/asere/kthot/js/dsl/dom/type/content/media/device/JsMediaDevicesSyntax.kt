package net.asere.kthot.js.dsl.dom.type.content.media.device

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement

class JsMediaDevicesSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMediaDevices>(value),
    JsMediaDevices {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaDevices.Companion.syntax(value: String): JsMediaDevicesSyntax =
    JsMediaDevicesSyntax(value)

fun JsMediaDevices.Companion.syntax(value: JsElement): JsMediaDevicesSyntax =
    JsMediaDevicesSyntax(value)