package net.asere.kthot.js.dsl.dom.type.data.geo.position

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsGeolocationPositionRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsGeolocationPosition>(
    name ?: "geolocation_position_${ReferenceId.nextRefInt()}",
    
), JsGeolocationPosition, JsReference<JsGeolocationPosition> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsGeolocationPosition.Companion.ref(name: String? = null): JsGeolocationPositionRef =
    JsGeolocationPositionRef(name)

@OptIn(JsInternalApi::class)
fun JsGeolocationPosition.Companion.ref(element: JsElement): JsGeolocationPositionRef =
    JsGeolocationPositionRef(element.present())

@OptIn(JsInternalApi::class)
fun JsGeolocationPosition.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsGeolocationPositionRef, JsGeolocationPosition>() {
    override val reference: JsGeolocationPositionRef = JsGeolocationPositionRef(name)
}