package net.asere.kthot.js.dsl.type.date

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Date object. Extends the base JsObject.
 */
interface JsDate : JsObject {

    fun getDate(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getDate")))

    fun getDay(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getDay")))

    fun getFullYear(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getFullYear")))

    fun getHours(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getHours")))

    fun getMilliseconds(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getMilliseconds")))

    fun getMinutes(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getMinutes")))

    fun getMonth(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getMonth")))

    fun getSeconds(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getSeconds")))

    fun getTime(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getTime")))

    fun getTimezoneOffset(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("getTimezoneOffset")))

    fun setDate(day: JsNumber): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("setDate", day)))

    fun setFullYear(year: JsNumber, month: JsObject, day: JsObject): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("setFullYear", year, month, day)))

    fun setHours(hour: JsNumber, min: JsObject, sec: JsObject, ms: JsObject): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("setHours", hour, min, sec, ms)))

    fun setTime(milliseconds: JsNumber): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("setTime", milliseconds)))

    fun toDateString(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("toDateString")))

    fun toISOString(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("toISOString")))

    fun toLocaleString(locales: JsObject, options: JsObject): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("toLocaleString", locales, options)))

    fun toLocaleDateString(locales: JsObject, options: JsObject): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("toLocaleDateString", locales, options)))

    fun toLocaleTimeString(locales: JsObject, options: JsObject): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("toLocaleTimeString", locales, options)))

    fun valueOf(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("valueOf")))

    companion object {

        /**
         * Returns the number of milliseconds since the epoch for the current time (`Date.now()`).
         */
        fun now(): JsNumber =
            JsNumber.syntax(ChainOperation(JsObject.syntax("Date"), InvocationOperation("now")))

        /**
         * Parses a string date representation (`Date.parse(dateString)`).
         */
        fun parse(dateString: JsString): JsNumber =
            JsNumber.syntax(ChainOperation(JsObject.syntax("Date"), InvocationOperation("parse", dateString)))

        /**
         * Accepts arguments like the constructor and returns a timestamp in UTC (`Date.UTC(...)`).
         */
        fun UTC(year: JsNumber, month: JsNumber, vararg args: JsNumber): JsNumber =
            JsNumber.syntax(ChainOperation(JsObject.syntax("Date"), InvocationOperation("UTC", year, month, *args)))
    }
}