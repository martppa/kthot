package net.asere.kthot.js.dsl.type

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.obj.JsObjectSyntax

/**
 * Represents the JavaScript `undefined` primitive value.
 * This is a DSL extension object, allowing you to use `undefined` directly in your JavaScript DSL code.
 *
 * In JavaScript, `undefined` is a primitive value automatically assigned to variables that have just been declared,
 * or to formal arguments for which there are no actual arguments.
 */
@JsDsl
object Undefined : JsObjectSyntax(value = "undefined", isNullable = false), JsNothing