package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsNumberValue
import net.asere.kotlin.js.dsl.value.JsValue
import net.asere.kotlin.js.dsl.value.value

abstract class JsString : JsValue {
    companion object

    fun getLength(): JsSyntax = JsSyntax("${this}.length")

    fun charAt(index: JsNumber): JsSyntax = JsSyntax("${this}.charAt($index)")

    fun charCodeAt(index: JsNumber): JsSyntax = JsSyntax("${this}.charCodeAt($index)")

    private fun concat(vararg strings: JsString): JsSyntax {
        val args = strings.joinToString(", ") { "$it" }
        return JsSyntax("${this}.concat($args)")
    }

    fun endsWith(searchString: JsString, length: JsNumber? = null): JsSyntax {
        val lengthArg = length?.let { "$it" } ?: ""
        return JsSyntax("${this}.endsWith($searchString, $lengthArg)")
    }

    fun includes(searchString: JsString, position: JsNumber? = null): JsSyntax {
        val positionArg = position?.let { "$it" } ?: ""
        return JsSyntax("${this}.includes($searchString, $positionArg)")
    }

    fun indexOf(searchValue: JsSyntax, fromIndex: JsNumber? = null): JsSyntax {
        val fromIndexArg = fromIndex?.let { "$it" } ?: ""
        return JsSyntax("${this}.indexOf($searchValue, $fromIndexArg)")
    }

    fun lastIndexOf(searchValue: JsSyntax, fromIndex: JsNumber? = null): JsSyntax {
        val fromIndexArg = fromIndex?.let { "$it" } ?: ""
        return JsSyntax("${this}.lastIndexOf($searchValue, $fromIndexArg)")
    }

    fun padEnd(targetLength: JsNumber, padString: JsString? = null): JsSyntax {
        val padStringArg = padString?.let { "$it" } ?: ""
        return JsSyntax("${this}.padEnd($targetLength, $padStringArg)")
    }

    fun padStart(targetLength: JsNumber, padString: JsString? = null): JsSyntax {
        val padStringArg = padString?.let { "$it" } ?: ""
        return JsSyntax("${this}.padStart($targetLength, $padStringArg)")
    }

    fun repeat(count: JsNumber): JsSyntax = JsSyntax("${this}.repeat($count)")

    fun replace(searchValue: JsString, replaceValue: JsString): JsSyntax =
        JsSyntax("${this}.replace($searchValue, $replaceValue)")

    fun replaceAll(searchValue: JsString, replaceValue: JsString): JsSyntax =
        JsSyntax("${this}.replaceAll($searchValue, $replaceValue)")

    fun search(regexp: JsString): JsSyntax = JsSyntax("${this}.search($regexp)")

    fun slice(startIndex: JsNumber, endIndex: JsNumber? = null): JsSyntax {
        val endIndexArg = endIndex?.let { "$it" } ?: ""
        return JsSyntax("${this}.slice($startIndex, $endIndexArg)")
    }

    fun split(separator: JsSyntax? = null, limit: JsNumber? = null): JsSyntax {
        val separatorArg = separator?.let { "$it" } ?: ""
        val limitArg = limit?.let { "$it" } ?: ""
        return JsSyntax("${this}.split($separatorArg, $limitArg)")
    }

    fun startsWith(searchString: JsSyntax, position: JsNumber? = null): JsSyntax {
        val positionArg = position?.let { "$it" } ?: ""
        return JsSyntax("${this}.startsWith($searchString, $positionArg)")
    }

    fun substring(startIndex: JsNumber, endIndex: JsNumber? = null): JsSyntax {
        val endIndexArg = endIndex?.let { "$it" } ?: ""
        return JsSyntax("${this}.substring($startIndex, $endIndexArg)")
    }

    fun toLocaleLowerCase(locale: JsSyntax? = null): JsSyntax {
        val localeArg = locale?.let { "$it" } ?: ""
        return JsSyntax("${this}.toLocaleLowerCase($localeArg)")
    }

    fun toLocaleUpperCase(locale: JsSyntax? = null): JsSyntax {
        val localeArg = locale?.let { "$it" } ?: ""
        return JsSyntax("${this}.toLocaleUpperCase($localeArg)")
    }

    fun toLowerCase(): JsSyntax = JsSyntax("${this}.toLowerCase()")

    fun toUpperCase(): JsSyntax = JsSyntax("${this}.toUpperCase()")

    fun trim(): JsSyntax = JsSyntax("${this}.trim()")

    fun trimEnd(): JsSyntax = JsSyntax("${this}.trimEnd()")

    fun trimStart(): JsSyntax = JsSyntax("${this}.trimStart()")

    override fun toString(): String = present()
}

val String.js: JsString get() = JsString.value(this)