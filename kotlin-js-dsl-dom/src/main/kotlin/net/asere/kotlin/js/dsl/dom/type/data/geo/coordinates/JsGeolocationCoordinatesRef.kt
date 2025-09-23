package net.asere.kotlin.js.dsl.dom.type.data.geo.coordinates

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsGeolocationCoordinatesRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsGeolocationCoordinates>(
    name ?: "geolocation_coordinates_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsGeolocationCoordinates, JsReference<JsGeolocationCoordinates> {
    override fun toString(): String = present()
}

fun JsGeolocationCoordinates.Companion.ref(
    name: String? = null,
    isNullable: Boolean = false
): JsGeolocationCoordinatesRef =
    JsGeolocationCoordinatesRef(name, isNullable)

fun JsGeolocationCoordinates.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsGeolocationCoordinatesRef, JsGeolocationCoordinates>() {
    override val reference: JsGeolocationCoordinatesRef = JsGeolocationCoordinatesRef(name, isNullable)
}