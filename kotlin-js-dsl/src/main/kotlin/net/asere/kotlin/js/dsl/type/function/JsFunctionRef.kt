package net.asere.kotlin.js.dsl.type.function

import net.asere.kotlin.js.dsl.type.JsCallable
import net.asere.kotlin.js.dsl.type.obj.JsObjectRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

abstract class JsFunctionRef(
    name: String? = null,
) : JsObjectRef(name ?: "function_${ReferenceId.nextRefInt()}"), JsCallable {
    override fun toString(): String = present()
}