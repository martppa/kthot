package net.asere.kotlin.js.dsl.dom.type.media.device.info

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaDeviceInfoSyntax internal constructor(value: String) : JsReferenceSyntax<JsMediaDeviceInfo>(value),
    JsMediaDeviceInfo {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaDeviceInfo.Companion.syntax(value: String): JsMediaDeviceInfoSyntax = JsMediaDeviceInfoSyntax(value)
fun JsMediaDeviceInfo.Companion.syntax(value: JsElement): JsMediaDeviceInfoSyntax = JsMediaDeviceInfoSyntax(value)