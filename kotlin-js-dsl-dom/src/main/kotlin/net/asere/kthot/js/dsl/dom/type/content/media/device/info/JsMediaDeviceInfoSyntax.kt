package net.asere.kthot.js.dsl.dom.type.content.media.device.info

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsMediaDeviceInfoSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsMediaDeviceInfo>(value, isNullable),
    JsMediaDeviceInfo {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsMediaDeviceInfo.Companion.syntax(value: String, isNullable: Boolean = false): JsMediaDeviceInfo =
    JsMediaDeviceInfoSyntax(value, isNullable)

fun JsMediaDeviceInfo.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsMediaDeviceInfo =
    JsMediaDeviceInfoSyntax(value, isNullable)