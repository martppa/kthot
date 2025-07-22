package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.callable.JsLambdaCommons
import net.asere.kotlin.js.dsl.reference.JsLambdaRefCommons

class JsLambdaSyntax<Reference : JsLambdaRefCommons<Reference>, Lambda : JsLambdaCommons>(
    reference: Reference,
    lambda: Lambda
) : JsResultSyntax<Reference>(
    innerObject = reference,
    syntax = JsSyntax("$lambda")
)