package net.asere.kthot.js.dsl.dom.type.window.navigator

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.dom.type.window.location.JsLocation
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsNavigatorRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsNavigator>(
    name ?: "navigator_${ReferenceId.nextRefInt()}",
    
), JsNavigator, JsReference<JsNavigator> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsNavigator.Companion.ref(name: String? = null): JsNavigatorRef =
    JsNavigatorRef(name)

@OptIn(JsInternalApi::class)
fun JsLocation.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsNavigatorRef, JsNavigator>() {
        override val reference: JsNavigatorRef = JsNavigatorRef(name)
    }