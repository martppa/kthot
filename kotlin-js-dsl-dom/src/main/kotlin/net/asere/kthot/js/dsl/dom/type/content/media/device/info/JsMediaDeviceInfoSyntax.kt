package net.asere.kthot.js.dsl.dom.type.content.media.device.info

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsMediaDeviceInfoSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMediaDeviceInfo>(value),
    JsMediaDeviceInfo {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaDeviceInfo.Companion.syntax(value: String): JsMediaDeviceInfo =
    JsMediaDeviceInfoSyntax(value)

fun JsMediaDeviceInfo.Companion.syntax(value: JsElement): JsMediaDeviceInfo =
    JsMediaDeviceInfoSyntax(value)