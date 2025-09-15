package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.group.Groupable

class JsAwaitSyntax(value: JsAsyncCallable) : JsSyntax("await $value"), Groupable