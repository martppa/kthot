package net.asere.kthot.js.dsl.dom.type.window.screen

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsScreenRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsScreen>(
    name ?: "screen_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsScreen, JsReference<JsScreen> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsScreen.Companion.ref(name: String? = null, isNullable: Boolean = false): JsScreenRef =
    JsScreenRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsScreen.Companion.ref(element: JsElement, isNullable: Boolean = false): JsScreenRef =
    JsScreenRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsScreen.Companion.def(
    name: String? = null,
    isNullable: Boolean = false
): JsPrintableDefinition<JsScreenRef, JsScreen> =
    object : JsPrintableDefinition<JsScreenRef, JsScreen>() {
        override val reference: JsScreenRef = JsScreenRef(name = name, isNullable)
    }