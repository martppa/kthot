package net.asere.kotlin.js.dsl.dom.type.media.device

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaDevicesSyntax internal constructor(value: String, isNullable: Boolean = false) :
    JsReferenceSyntax<JsMediaDevices>(value, isNullable),
    JsMediaDevices {
    internal constructor(value: JsElement, isNullable: Boolean = false) : this("$value", isNullable)
}

fun JsMediaDevices.Companion.syntax(value: String, isNullable: Boolean = false): JsMediaDevicesSyntax =
    JsMediaDevicesSyntax(value, isNullable)

fun JsMediaDevices.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsMediaDevicesSyntax =
    JsMediaDevicesSyntax(value, isNullable)