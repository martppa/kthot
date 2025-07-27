package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsHistory
import net.asere.kotlin.js.dsl.dom.type.JsLocation
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsLocationRef internal constructor(
    name: String? = null
) : JsValueRef<JsLocation>(
    name ?: "location_${JsReference.nextRefInt()}"
), JsLocation, JsReference<JsLocation> {
    override fun toString(): String = present()
}

fun JsLocation.Companion.ref(name: String? = null) = JsLocationRef(name)

fun JsLocation.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsLocationRef, JsLocation>() {
    override val reference: JsLocationRef = JsLocationRef(name)
}