package net.asere.kthot.js.dsl.dom.type.data.geo.position

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsGeolocationPositionRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsGeolocationPosition>(
    name ?: "geolocation_position_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsGeolocationPosition, JsReference<JsGeolocationPosition> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsGeolocationPosition.Companion.ref(name: String? = null, isNullable: Boolean = false): JsGeolocationPositionRef =
    JsGeolocationPositionRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsGeolocationPosition.Companion.ref(element: JsElement, isNullable: Boolean = false): JsGeolocationPositionRef =
    JsGeolocationPositionRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsGeolocationPosition.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsGeolocationPositionRef, JsGeolocationPosition>() {
    override val reference: JsGeolocationPositionRef = JsGeolocationPositionRef(name, isNullable)
}