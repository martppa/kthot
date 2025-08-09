package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.obj.JsObjectSyntax

/**
 * Represents the JavaScript `undefined` primitive value.
 * This is a DSL extension object, allowing you to use `undefined` directly in your JavaScript DSL code.
 *
 * In JavaScript, `undefined` is a primitive value automatically assigned to variables that have just been declared,
 * or to formal arguments for which there are no actual arguments.
 */
@JsDsl
object undefined : JsObjectSyntax(value = "undefined", isNullable = false)