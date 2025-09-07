package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

class JsAsyncSyntax(value: JsElement) : JsSyntax("async $value"), JsAsyncCallable