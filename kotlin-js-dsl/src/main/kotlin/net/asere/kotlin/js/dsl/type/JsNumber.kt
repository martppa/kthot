package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.reference.JsNumberRef
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ArithmeticalComparable
import net.asere.kotlin.js.dsl.value.JsValue
import net.asere.kotlin.js.dsl.value.value

interface JsNumber : JsValue, ArithmeticalComparable {

    fun toExponential(fractionDigits: JsNumber? = null): JsSyntax {
        val arg = fractionDigits?.let { "$it" } ?: ""
        return JsSyntax("${this}.toExponential($arg)")
    }

    fun toFixed(digits: JsNumber? = null): JsSyntax {
        val arg = digits?.let { "$it" } ?: ""
        return JsSyntax("${this}.toFixed($arg)")
    }

    fun toLocaleString(locales: JsSyntax? = null, options: JsSyntax? = null): JsSyntax {
        val localesArg = locales?.let { "$it" } ?: ""
        val optionsArg = options?.let { ", $it" } ?: ""
        return JsSyntax("${this}.toLocaleString($localesArg$optionsArg)")
    }

    fun toPrecision(precision: JsNumber? = null): JsSyntax {
        val arg = precision?.let { "$it" } ?: ""
        return JsSyntax("${this}.toPrecision($arg)")
    }

    fun toJsString(radix: JsNumber? = null): JsSyntax {
        val arg = radix?.let { "$it" } ?: ""
        return JsSyntax("${this}.toString($arg)")
    }

    fun valueOf(): JsSyntax = JsSyntax("${this}.valueOf()")

    companion object {
        fun isFinite(value: JsNumber): JsSyntax = JsSyntax("Number.isFinite($value)")

        fun isInteger(value: JsNumber): JsSyntax = JsSyntax("Number.isInteger($value)")

        fun isNaN(value: JsNumber): JsSyntax = JsSyntax("Number.isNaN($value)")

        fun isSafeInteger(value: JsNumber): JsSyntax = JsSyntax("Number.isSafeInteger($value)")

        fun parseFloat(string: JsString): JsSyntax = JsSyntax("Number.parseFloat($string)")

        fun parseInt(string: JsString, radix: JsNumberRef? = null): JsSyntax {
            val radixArg = radix?.let { ", $it" } ?: ""
            return JsSyntax("Number.parseInt($string$radixArg)")
        }
    }
}

val Number.js: JsNumber get() = JsNumber.value(this)