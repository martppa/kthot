package net.asere.kthot.js.dsl.type.function

import net.asere.kthot.js.dsl.type.JsCallable
import net.asere.kthot.js.dsl.type.obj.JsObjectRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

abstract class JsFunctionRef(
    name: String? = null,
) : JsObjectRef(name ?: "function_${ReferenceId.nextRefInt()}"), JsCallable {
    override fun toString(): String = present()
}