package net.asere.kotlin.js.dsl.dom.type.screen

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

open class JsScreenRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsScreen>(
    name ?: "screen_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsScreen, JsReference<JsScreen> {
    override fun toString(): String = present()
}

fun JsScreen.Companion.ref(name: String? = null, isNullable: Boolean = false): JsScreenRef =
    JsScreenRef(name, isNullable)

fun JsScreen.Companion.def(
    name: String? = null,
    isNullable: Boolean = false
): JsPrintableDefinition<JsScreenRef, JsScreen> =
    object : JsPrintableDefinition<JsScreenRef, JsScreen>() {
        override val reference: JsScreenRef = JsScreenRef(name = name, isNullable)
    }