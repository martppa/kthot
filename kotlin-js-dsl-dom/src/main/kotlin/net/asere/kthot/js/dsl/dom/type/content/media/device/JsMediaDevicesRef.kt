package net.asere.kthot.js.dsl.dom.type.content.media.device

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.dom.type.window.location.JsLocation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsMediaDevicesRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaDevices>(
    name ?: "media_devices_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaDevices, JsReference<JsMediaDevices> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsMediaDevices.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaDevicesRef =
    JsMediaDevicesRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsMediaDevices.Companion.ref(element: JsElement, isNullable: Boolean = false): JsMediaDevicesRef =
    JsMediaDevicesRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsLocation.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaDevicesRef, JsMediaDevices>() {
        override val reference: JsMediaDevicesRef = JsMediaDevicesRef(name, isNullable)
    }