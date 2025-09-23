package net.asere.kotlin.js.dsl.dom.type.content.media.device.info

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsMediaDeviceInfoRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaDeviceInfo>(
    name ?: "media_device_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaDeviceInfo, JsReference<JsMediaDeviceInfo> {
    override fun toString(): String = present()
}

fun JsMediaDeviceInfo.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaDeviceInfoRef =
    JsMediaDeviceInfoRef(name, isNullable)

fun JsMediaDeviceInfo.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaDeviceInfoRef, JsMediaDeviceInfo>() {
        override val reference: JsMediaDeviceInfoRef = JsMediaDeviceInfoRef(name, isNullable)
    }