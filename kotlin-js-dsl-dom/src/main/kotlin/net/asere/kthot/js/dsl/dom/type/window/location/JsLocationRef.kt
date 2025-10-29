package net.asere.kthot.js.dsl.dom.type.window.location

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsLocationRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsLocation>(
    name ?: "location_${ReferenceId.nextRefInt()}",
    
), JsLocation, JsReference<JsLocation> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsLocation.Companion.ref(name: String? = null): JsLocationRef =
    JsLocationRef(name)

@OptIn(JsInternalApi::class)
fun JsLocation.Companion.ref(element: JsElement): JsLocationRef =
    JsLocationRef(element.present())

@OptIn(JsInternalApi::class)
fun JsLocation.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsLocationRef, JsLocation>() {
        override val reference: JsLocationRef = JsLocationRef(name)
    }