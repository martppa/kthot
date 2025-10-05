package net.asere.kthot.js.dsl.type.number

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.ArithmeticalComparable
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation.*
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.Undefined
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript number primitive value.
 * This interface extends [JsValue] and [ArithmeticalComparable], allowing arithmetic operations and comparisons.
 */
interface JsNumber : JsValue, ArithmeticalComparable {

    /**
     * Returns a string representing the [JsNumber] object in exponential notation.
     *
     * In JavaScript, this corresponds to `number.toExponential(fractionDigits)`.
     * @param fractionDigits An optional [JsNumber] specifying the number of digits after the decimal point.
     * @return A [JsString] object representing the JavaScript method call that returns a string.
     */
    fun toExponential(fractionDigits: JsNumber? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("toExponential", fractionDigits ?: Undefined)))
    }

    /**
     * Returns a string representing the [JsNumber] object in fixed-point notation.
     *
     * In JavaScript, this corresponds to `number.toFixed(digits)`.
     * @param digits An optional [JsNumber] specifying the number of digits to appear after the decimal point.
     * @return A [JsNumber] object representing the JavaScript method call that returns a string.
     */
    fun toFixed(digits: JsNumber? = null): JsNumber {
        return JsNumber.syntax(ChainOperation(this, InvocationOperation("toFixed", digits ?: Undefined)))
    }

    /**
     * Returns a string with a language-sensitive representation of this number.
     *
     * In JavaScript, this corresponds to `number.toLocaleString(locales, options)`.
     * @param locales An optional [JsValue] representing a BCP 47 language tag or an array of such tags.
     * @param options An optional [JsValue] representing an object with configuration properties.
     * @return A [JsSyntax] object representing the JavaScript method call that returns a localized string.
     */
    fun toLocaleString(locales: JsValue? = null, options: JsValue? = null): JsSyntax {
        return JsSyntax(ChainOperation(this, InvocationOperation("toLocaleString", locales ?: Undefined, options ?: Undefined)))
    }

    /**
     * Returns a string representing the [JsNumber] object to a specified precision.
     *
     * In JavaScript, this corresponds to `number.toPrecision(precision)`.
     * @param precision An optional [JsNumber] specifying the number of significant digits.
     * @return A [JsNumber] object representing the JavaScript method call that returns a string.
     */
    fun toPrecision(precision: JsNumber? = null): JsNumber {
        return JsNumberSyntax(ChainOperation(this, InvocationOperation("toPrecision", precision ?: Undefined)))
    }

    /**
     * Returns a string representing the [JsNumber] object.
     *
     * In JavaScript, this corresponds to `number.toString(radix)`.
     * @param radix An optional [JsNumber] specifying the base (from 2 to 36) to use for representing numeric values.
     * @return A [JsString] object representing the JavaScript method call that returns a string.
     */
    fun toJsString(radix: JsNumber? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("toString", radix ?: Undefined)))
    }

    /**
     * Returns the primitive value of the [JsNumber] object.
     *
     * In JavaScript, this corresponds to `number.valueOf()`.
     * @return A [JsNumber] object representing the JavaScript method call that returns the primitive value.
     */
    fun valueOf(): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("valueOf")))

    operator fun div(rightHand: JsNumber): DivOperation = DivOperation(
        leftHand = JsNumber.syntax(this.groupIfGroupable()),
        rightHand = JsNumber.syntax(rightHand.groupIfGroupable())
    )

    operator fun minus(rightHand: JsNumber): MinusOperation = MinusOperation(
        leftHand = JsNumber.syntax(this.groupIfGroupable()),
        rightHand = JsNumber.syntax(rightHand.groupIfGroupable())
    )

    operator fun times(rightHand: JsNumber): TimesOperation = TimesOperation(
        leftHand = JsNumber.syntax(this.groupIfGroupable()),
        rightHand = JsNumber.syntax(rightHand.groupIfGroupable())
    )

    operator fun plus(rightHand: JsNumber): PlusOperation = PlusOperation(
        leftHand = JsNumber.syntax(this.groupIfGroupable()),
        rightHand = JsNumber.syntax(rightHand.groupIfGroupable())
    )

    operator fun rem(rightHand: JsNumber): ModOperation = ModOperation(
        leftHand = JsNumber.syntax(this.groupIfGroupable()),
        rightHand = JsNumber.syntax(rightHand.groupIfGroupable())
    )

    companion object {
        /**
         * Determines whether the passed value is a finite number.
         *
         * In JavaScript, this corresponds to `Number.isFinite(value)`.
         * @param value The [JsNumber] to be tested.
         * @return A [JsBoolean] object representing the JavaScript method call that returns a boolean.
         */
        fun isFinite(value: JsNumber): JsBoolean = JsBoolean.syntax(
            ChainOperation(JsString.syntax("Number"), InvocationOperation("isFinite", value))
        )

        /**
         * Determines whether the passed value is an integer.
         *
         * In JavaScript, this corresponds to `Number.isInteger(value)`.
         * @param value The [JsNumber] to be tested.
         * @return A [JsBoolean] object representing the JavaScript method call that returns a boolean.
         */
        fun isInteger(value: JsNumber): JsBoolean = JsBoolean.syntax(
            ChainOperation(JsString.syntax("Number"), InvocationOperation("isInteger", value))
        )

        /**
         * Determines whether the passed value is `NaN` (Not-a-Number).
         *
         * In JavaScript, this corresponds to `Number.isNaN(value)`.
         * @param value The [JsNumber] to be tested.
         * @return A [JsBoolean] object representing the JavaScript method call that returns a boolean.
         */
        fun isNaN(value: JsNumber): JsBoolean = JsBoolean.syntax(
            ChainOperation(JsString.syntax("Number"), InvocationOperation("isNaN", value))
        )

        /**
         * Determines whether the passed value is a safe integer.
         *
         * In JavaScript, this corresponds to `Number.isSafeInteger(value)`.
         * @param value The [JsNumber] to be tested.
         * @return A [JsBoolean] object representing the JavaScript method call that returns a boolean.
         */
        fun isSafeInteger(value: JsNumber): JsBoolean = JsBoolean.syntax(
            ChainOperation(JsString.syntax("Number"), InvocationOperation("isSafeInteger", value))
        )

        /**
         * Parses a string argument and returns a floating-point number.
         *
         * In JavaScript, this corresponds to `Number.parseFloat(string)`.
         * @param string The [JsString] to be parsed.
         * @return A [JsNumber] object representing the JavaScript method call that returns a number.
         */
        fun parseFloat(string: JsString): JsNumber =
            JsNumber.syntax(
                ChainOperation(JsString.syntax("Number"),
                    InvocationOperation("parseFloat", string)))

        /**
         * Parses a string argument and returns an integer of the specified radix (base).
         *
         * In JavaScript, this corresponds to `Number.parseInt(string, radix)`.
         * @param string The [JsString] to be parsed.
         * @param radix An optional [JsNumberRef] specifying the base of the number in the string.
         * @return A [JsNumber] object representing the JavaScript method call that returns an integer.
         */
        fun parseInt(string: JsString, radix: JsNumberRef? = null): JsNumber {
            return JsNumber.syntax(
                ChainOperation(
                    JsString.syntax("Number"),
                    InvocationOperation("parseInt", string, radix ?: Undefined)
                )
            )
        }
    }
}

/**
 * Extension property to convert a Kotlin [Number] to a [JsNumber] instance.
 * This provides a convenient way to use Kotlin numbers directly in JavaScript DSL.
 */
val Number.js: JsNumber get() = JsNumber.value(this)