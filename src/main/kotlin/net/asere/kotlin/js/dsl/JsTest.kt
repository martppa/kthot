package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsClass(name = "Test")
class JsTest : JsElement, JsValue, JsObject {
    val a: JsString = JsString.ref()
    val b: Int = 5
    fun getString(number: JsNumber, dom: JsDomObject): JsString {
        return "".js
    }

    override fun present(): String {
        return ""
    }
}

fun main() {
    val test: Test
}