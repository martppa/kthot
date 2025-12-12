package net.asere.kthot.js.dsl.type.intl.locale

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsLocaleRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsLocale>(
    name ?: "locale_object_${ReferenceId.nextRefInt()}",
), JsLocale, JsReference<JsLocale> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsLocale.Companion.ref(name: String? = null): JsLocaleRef =
    JsLocaleRef(name)

@OptIn(JsInternalApi::class)
fun JsLocale.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsLocaleRef, JsLocale>() {
    override val reference: JsLocaleRef = JsLocaleRef(name)
}