package net.asere.kotlin.js.dsl.dom.type.data.geo.position

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsGeolocationPositionRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsGeolocationPosition>(
    name ?: "geolocation_position_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsGeolocationPosition, JsReference<JsGeolocationPosition> {
    override fun toString(): String = present()
}

fun JsGeolocationPosition.Companion.ref(name: String? = null, isNullable: Boolean = false): JsGeolocationPositionRef =
    JsGeolocationPositionRef(name, isNullable)

fun JsGeolocationPosition.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsGeolocationPositionRef, JsGeolocationPosition>() {
    override val reference: JsGeolocationPositionRef = JsGeolocationPositionRef(name, isNullable)
}