package net.asere.kthot.js.dsl.syntax.async

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.group.Groupable

class JsAwaitSyntax(value: JsAsyncCallable) : JsSyntax("await $value"), Groupable