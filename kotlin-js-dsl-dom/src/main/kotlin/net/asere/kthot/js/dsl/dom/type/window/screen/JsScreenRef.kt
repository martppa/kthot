package net.asere.kthot.js.dsl.dom.type.window.screen

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsScreenRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsScreen>(
    name ?: "screen_${ReferenceId.nextRefInt()}",
    
), JsScreen, JsReference<JsScreen> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsScreen.Companion.ref(name: String? = null): JsScreenRef =
    JsScreenRef(name)

@OptIn(JsInternalApi::class)
fun JsScreen.Companion.ref(element: JsElement): JsScreenRef =
    JsScreenRef(element.present())

@OptIn(JsInternalApi::class)
fun JsScreen.Companion.def(
    name: String? = null,
    
): JsPrintableDefinition<JsScreenRef, JsScreen> =
    object : JsPrintableDefinition<JsScreenRef, JsScreen>() {
        override val reference: JsScreenRef = JsScreenRef(name = name)
    }