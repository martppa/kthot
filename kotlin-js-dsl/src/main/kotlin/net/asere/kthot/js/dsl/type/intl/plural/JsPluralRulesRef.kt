package net.asere.kthot.js.dsl.type.intl.plural

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsPluralRulesRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsPluralRules>(
    name ?: "plural_rules_object_${ReferenceId.nextRefInt()}",
), JsPluralRules, JsReference<JsPluralRules> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsPluralRules.Companion.ref(name: String? = null): JsPluralRulesRef =
    JsPluralRulesRef(name)

@OptIn(JsInternalApi::class)
fun JsPluralRules.Companion.ref(element: JsElement): JsPluralRulesRef =
    JsPluralRulesRef(element.present())

@OptIn(JsInternalApi::class)
fun JsPluralRules.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsPluralRulesRef, JsPluralRules>() {
    override val reference: JsPluralRulesRef = JsPluralRulesRef(name)
}