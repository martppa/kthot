package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.callable.JsLambdaCommons

class JsLambdaSyntax<T : JsLambdaCommons>(lambda: T) : JsResultSyntax<T>(
    innerObject = lambda,
    syntax = JsSyntax("$lambda")
)