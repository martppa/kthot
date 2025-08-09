package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.string.syntax

@JsClass(name = "Test")
abstract class JsTest<T, P, ParameterElement, ParameterQuoco> where P : List<String>, P : JsElement, ParameterElement : JsArray<JsString>, ParameterQuoco : JsArray<JsNumber> {
    val a: JsString = JsString.ref()
    val b: Int = 5
    abstract val q: ParameterElement
    abstract val c: ParameterQuoco
    abstract val list: JsArray<ParameterElement>
    fun getString(number: JsNumber, dom: JsDomObject): JsString = JsString.syntax(value = js {
        Log(number)
    })

    fun lol(): String = ""
}

@JsClass()
abstract class NestedClass<T : JsNumber> : JsObject {
    val number: T get() = TODO()
}

@JsClass()
class Request<T : JsNumber, P : JsArray<JsString>, Q : JsNumber> {
    val obj: T get() = throw IllegalStateException()
    val array: JsArray<P> get() = throw IllegalStateException()
    val numberArray: JsArray<Q> get() = throw IllegalStateException()
    fun getNested(number: JsNumber): JsNestedClass<T> = TODO()
}