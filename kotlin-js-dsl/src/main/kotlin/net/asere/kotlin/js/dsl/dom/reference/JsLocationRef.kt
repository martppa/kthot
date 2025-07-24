package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsLocation
import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.reference.JsValueRef

class JsLocationRef internal constructor(
    name: String? = null
) : JsValueRef<JsLocation>(
    name ?: "location_${JsReference.nextRefInt()}"
), JsLocation, JsDeclarableReference<JsLocation> {
    override fun toString(): String = present()
}