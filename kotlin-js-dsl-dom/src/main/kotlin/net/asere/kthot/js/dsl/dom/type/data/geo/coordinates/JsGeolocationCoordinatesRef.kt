package net.asere.kthot.js.dsl.dom.type.data.geo.coordinates

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsGeolocationCoordinatesRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsGeolocationCoordinates>(
    name ?: "geolocation_coordinates_${ReferenceId.nextRefInt()}",
    
), JsGeolocationCoordinates, JsReference<JsGeolocationCoordinates> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsGeolocationCoordinates.Companion.ref(
    name: String? = null,
    
): JsGeolocationCoordinatesRef =
    JsGeolocationCoordinatesRef(name)

@OptIn(JsInternalApi::class)
fun JsGeolocationCoordinates.Companion.ref(
    element: JsElement,
    
): JsGeolocationCoordinatesRef =
    JsGeolocationCoordinatesRef(element.present())

@OptIn(JsInternalApi::class)
fun JsGeolocationCoordinates.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsGeolocationCoordinatesRef, JsGeolocationCoordinates>() {
    override val reference: JsGeolocationCoordinatesRef = JsGeolocationCoordinatesRef(name)
}