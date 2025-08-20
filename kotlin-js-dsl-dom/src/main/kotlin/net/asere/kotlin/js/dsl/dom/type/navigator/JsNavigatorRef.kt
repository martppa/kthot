package net.asere.kotlin.js.dsl.dom.type.navigator

import net.asere.kotlin.js.dsl.dom.type.location.JsLocation
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsNavigatorRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsNavigator>(
    name ?: "navigator_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsNavigator, JsReference<JsNavigator> {
    override fun toString(): String = present()
}

fun JsNavigator.Companion.ref(name: String? = null, isNullable: Boolean = false): JsNavigatorRef =
    JsNavigatorRef(name, isNullable)

fun JsLocation.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsNavigatorRef, JsNavigator>() {
        override val reference: JsNavigatorRef = JsNavigatorRef(name, isNullable)
    }