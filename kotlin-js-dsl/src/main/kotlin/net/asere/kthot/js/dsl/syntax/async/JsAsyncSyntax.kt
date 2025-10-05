package net.asere.kthot.js.dsl.syntax.async

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

class JsAsyncSyntax(value: JsElement) : JsSyntax("async $value"), JsAsyncCallable