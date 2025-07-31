package net.asere.kotlin.js.dsl.dom.type.media.device

import net.asere.kotlin.js.dsl.dom.type.location.JsLocation
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsMediaDevicesRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaDevices>(
    name ?: "media_devices_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaDevices, JsReference<JsMediaDevices> {
    override fun toString(): String = present()
}

fun JsMediaDevices.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaDevicesRef =
    JsMediaDevicesRef(name, isNullable)

fun JsLocation.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaDevicesRef, JsMediaDevices>() {
        override val reference: JsMediaDevicesRef = JsMediaDevicesRef(name, isNullable)
    }