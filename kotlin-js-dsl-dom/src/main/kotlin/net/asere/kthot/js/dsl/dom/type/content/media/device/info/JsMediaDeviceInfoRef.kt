package net.asere.kthot.js.dsl.dom.type.content.media.device.info

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsMediaDeviceInfoRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsMediaDeviceInfo>(
    name ?: "media_device_${ReferenceId.nextRefInt()}",
), JsMediaDeviceInfo, JsReference<JsMediaDeviceInfo> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsMediaDeviceInfo.Companion.ref(name: String? = null): JsMediaDeviceInfoRef =
    JsMediaDeviceInfoRef(name)

@OptIn(JsInternalApi::class)
fun JsMediaDeviceInfo.Companion.ref(element: JsElement): JsMediaDeviceInfoRef =
    JsMediaDeviceInfoRef(element.present())

@OptIn(JsInternalApi::class)
fun JsMediaDeviceInfo.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsMediaDeviceInfoRef, JsMediaDeviceInfo>() {
        override val reference: JsMediaDeviceInfoRef = JsMediaDeviceInfoRef(name)
    }