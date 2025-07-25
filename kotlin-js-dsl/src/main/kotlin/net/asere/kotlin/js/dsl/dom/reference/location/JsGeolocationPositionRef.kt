package net.asere.kotlin.js.dsl.dom.reference.location

import net.asere.kotlin.js.dsl.dom.type.location.JsGeolocationPosition
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsGeolocationPositionRef internal constructor(
    name: String? = null
) : JsValueRef<JsGeolocationPosition>(
    name ?: "geolocation_position_${JsReference.nextRefInt()}"
), JsGeolocationPosition, JsReference<JsGeolocationPosition> {
    override fun toString(): String = present()
}

fun JsGeolocationPosition.Companion.ref(name: String? = null) = JsGeolocationPositionRef(name)

fun JsGeolocationPosition.Companion.def(name: String? = null) = object : JsDefinition<JsGeolocationPositionRef, JsGeolocationPosition> {
    override val reference: JsGeolocationPositionRef = JsGeolocationPositionRef(name)
}