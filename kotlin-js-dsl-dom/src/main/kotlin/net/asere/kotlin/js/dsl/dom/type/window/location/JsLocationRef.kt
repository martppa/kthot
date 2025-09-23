package net.asere.kotlin.js.dsl.dom.type.window.location

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsLocationRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsLocation>(
    name ?: "location_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsLocation, JsReference<JsLocation> {
    override fun toString(): String = present()
}

fun JsLocation.Companion.ref(name: String? = null, isNullable: Boolean = false): JsLocationRef =
    JsLocationRef(name, isNullable)

fun JsLocation.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsLocationRef, JsLocation>() {
        override val reference: JsLocationRef = JsLocationRef(name, isNullable)
    }