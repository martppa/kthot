package net.asere.kotlin.js.dsl.dom.reference.location

import net.asere.kotlin.js.dsl.dom.type.location.JsGeolocationCoordinates
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.reference.ReferenceId

class JsGeolocationCoordinatesRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsGeolocationCoordinates>(
    name ?: "geolocation_coordinates_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsGeolocationCoordinates, JsReference<JsGeolocationCoordinates> {
    override fun toString(): String = present()
}

fun JsGeolocationCoordinates.Companion.ref(name: String? = null, isNullable: Boolean = false) =
    JsGeolocationCoordinatesRef(name, isNullable)

fun JsGeolocationCoordinates.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsGeolocationCoordinatesRef, JsGeolocationCoordinates>() {
    override val reference: JsGeolocationCoordinatesRef = JsGeolocationCoordinatesRef(name)
}