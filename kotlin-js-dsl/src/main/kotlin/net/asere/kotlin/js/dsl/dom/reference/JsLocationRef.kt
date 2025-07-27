package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsLocation
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.reference.ReferenceId

class JsLocationRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsLocation>(
    name ?: "location_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsLocation, JsReference<JsLocation> {
    override fun toString(): String = present()
}

fun JsLocation.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsLocationRef(name, isNullable)

fun JsLocation.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsLocationRef, JsLocation>() {
        override val reference: JsLocationRef = JsLocationRef(name, isNullable)
    }