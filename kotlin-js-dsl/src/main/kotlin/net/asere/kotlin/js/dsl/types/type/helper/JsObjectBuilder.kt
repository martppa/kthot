package net.asere.kotlin.js.dsl.types.type.helper

import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.value.JsValue
import net.asere.kotlin.js.dsl.types.value.value

class JsObjectBuilder {
    private val properties = mutableListOf<String>()
    fun property(key: String, value: JsValue) {
        properties.add("$key: $value")
    }
    fun build(): JsObject = JsObject.value("{ \n${properties.joinToString(",\n")} \n}")
}