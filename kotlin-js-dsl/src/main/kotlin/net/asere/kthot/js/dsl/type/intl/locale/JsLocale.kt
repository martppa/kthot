package net.asere.kthot.js.dsl.type.intl.locale

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.Locale object.
 * This object holds information about a Unicode locale identifier.
 */
interface JsLocale : JsObject {

    val language: JsString get() = JsString.syntax(ChainOperation(this, "language"))
    val script: JsString get() = JsString.syntax(ChainOperation(this, "script"))
    val region: JsString get() = JsString.syntax(ChainOperation(this, "region"))
    val baseName: JsString get() = JsString.syntax(ChainOperation(this, "baseName"))
    val calendar: JsString get() = JsString.syntax(ChainOperation(this, "calendar"))
    val collation: JsString get() = JsString.syntax(ChainOperation(this, "collation"))
    val numberingSystem: JsString get() = JsString.syntax(ChainOperation(this, "numberingSystem"))
    val hourCycle: JsString get() = JsString.syntax(ChainOperation(this, "hourCycle"))
    val textInfo: JsObject get() = JsObject.syntax(ChainOperation(this, "textInfo"))
    val weekInfo: JsObject get() = JsObject.syntax(ChainOperation(this, "weekInfo"))

    /**
     * Returns the full normalized locale identifier string.
     * Corresponds to `locale.toString()`.
     */
    fun jsToString(): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("toString")))

    /**
     * Returns a new Locale object with the language tag replaced.
     * Corresponds to `locale.withLocale(locale)`.
     * @param locale A [JsObject] (representing [JsString] or [JsLocale]) to merge with.
     * @return A new [JsLocale] instance.
     */
    fun withLocale(locale: JsObject): JsLocale =
        JsLocale.syntax(ChainOperation(this, InvocationOperation("withLocale", locale)))

    /**
     * Returns a new Locale object with the calendar system replaced.
     * Corresponds to `locale.withCalendar(calendar)`.
     * @param calendar A [JsString] representing the new calendar system (e.g., "gregory").
     * @return A new [JsLocale] instance.
     */
    fun withCalendar(calendar: JsString): JsLocale =
        JsLocale.syntax(ChainOperation(this, InvocationOperation("withCalendar", calendar)))

    companion object
}