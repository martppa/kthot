package net.asere.kotlin.js.dsl.dom.reference.location

import net.asere.kotlin.js.dsl.dom.type.location.JsGeolocationCoordinates
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsGeolocationCoordinatesRef internal constructor(
    name: String? = null
) : JsValueRef<JsGeolocationCoordinates>(
    name ?: "geolocation_coordinates_${JsReference.nextRefInt()}"
), JsGeolocationCoordinates, JsReference<JsGeolocationCoordinates> {
    override fun toString(): String = present()
}

fun JsGeolocationCoordinates.Companion.ref(name: String? = null) = JsGeolocationCoordinatesRef(name)

fun JsGeolocationCoordinates.Companion.def(name: String? = null) = object : JsDefinition<JsGeolocationCoordinatesRef, JsGeolocationCoordinates> {
    override val reference: JsGeolocationCoordinatesRef = JsGeolocationCoordinatesRef(name)
}