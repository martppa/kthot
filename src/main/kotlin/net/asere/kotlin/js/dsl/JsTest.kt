package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.declaration.DeclarationType
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.ksp.annotation.JsConstructor
import net.asere.kotlin.js.dsl.ksp.annotation.JsFunction
import net.asere.kotlin.js.dsl.ksp.annotation.JsProperty
import net.asere.kotlin.js.dsl.ksp.js.Super
import net.asere.kotlin.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.number.value
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.def
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.string.syntax

@JsClass
data class Test @JsConstructor constructor(
    @JsProperty
    val property: JsString = JsString.ref("property")
) : JavaScriptClass() {

    @JsProperty
    val number: JsNumber = JsNumber.ref("number")

    init {
        Constructor {
            Super(number)
            This.property assign property
        }
    }

    @JsFunction
    fun function1(value: JsNumber) = js {
        This.property assign value
    }
}

fun main() {
    KotlinJsl.initialize()
    val syntax = js {
        val foo = +JsNumber.def("foo")
            .declare(DeclarationType.Let)
            .assignValue(5)
        val testObject = Const { JsTest.def("testObject") } assign JsTest.new(JsString.ref("value"))
        testObject
    }
    println(syntax)
}