package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.string.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue
import java.util.Queue
import java.util.Spliterator

@JsClass(name = "Test")
abstract class JsTest<T, P, Q> where P : List<String>, P : JsElement, Q : JsArray<JsString> {
    val a: JsString = JsString.ref()
    val b: Int = 5
    fun getString(number: JsNumber, dom: JsDomObject): JsString = JsString.syntax(value = js {
        Log(number)
    })

    fun lol(): String = ""
}