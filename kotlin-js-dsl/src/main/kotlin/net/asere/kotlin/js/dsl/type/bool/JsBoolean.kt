package net.asere.kotlin.js.dsl.type.bool

import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.syntax.operational.logical.LogicalComparable
import net.asere.kotlin.js.dsl.type.value.JsValue
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.syntax

/**
 * Represents a JavaScript boolean primitive value (`true` or `false`).
 * This interface extends [JsValue] and [LogicalComparable], allowing boolean operations and comparisons.
 */
interface JsBoolean : JsValue, LogicalComparable {

    /**
     * Converts the boolean value to its string representation ("true" or "false").
     *
     * In JavaScript, this corresponds to `booleanValue.toString()`.
     * @return A [JsString] object representing the JavaScript method call that returns a string.
     */
    fun jsToString(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("toString")))

    companion object
}

/**
 * Extension property to convert a Kotlin [Boolean] to a [JsBoolean] instance.
 * This provides a convenient way to use Kotlin booleans directly in JavaScript DSL.
 */
val Boolean.js: JsBoolean get() = JsBoolean.value(this)

operator fun Boolean.unaryPlus(): JsBoolean = this.js

val True = true.js
val False = false.js