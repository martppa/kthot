package net.asere.kotlin.js.dsl.dom.reference.location

import net.asere.kotlin.js.dsl.dom.type.location.JsGeolocationPosition
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsGeolocationPositionRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsGeolocationPosition>(
    name ?: "geolocation_position_${JsReference.nextRefInt()}",
    isNullable = isNullable,
), JsGeolocationPosition, JsReference<JsGeolocationPosition> {
    override fun toString(): String = present()
}

fun JsGeolocationPosition.Companion.ref(name: String? = null, isNullable: Boolean = false) =
    JsGeolocationPositionRef(name, isNullable)

fun JsGeolocationPosition.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsGeolocationPositionRef, JsGeolocationPosition>() {
    override val reference: JsGeolocationPositionRef = JsGeolocationPositionRef(name)
}