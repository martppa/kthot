package net.asere.kotlin.js.dsl.dom.type.data.geo.coordinates

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsGeolocationCoordinatesRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsGeolocationCoordinates>(
    name ?: "geolocation_coordinates_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsGeolocationCoordinates, JsReference<JsGeolocationCoordinates> {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsGeolocationCoordinates.Companion.ref(
    name: String? = null,
    isNullable: Boolean = false
): JsGeolocationCoordinatesRef =
    JsGeolocationCoordinatesRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsGeolocationCoordinates.Companion.ref(
    element: JsElement,
    isNullable: Boolean = false
): JsGeolocationCoordinatesRef =
    JsGeolocationCoordinatesRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsGeolocationCoordinates.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsGeolocationCoordinatesRef, JsGeolocationCoordinates>() {
    override val reference: JsGeolocationCoordinatesRef = JsGeolocationCoordinatesRef(name, isNullable)
}