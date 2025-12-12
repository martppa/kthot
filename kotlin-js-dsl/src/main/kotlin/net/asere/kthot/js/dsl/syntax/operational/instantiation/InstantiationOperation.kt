package net.asere.kthot.js.dsl.syntax.operational.instantiation

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation

class InstantiationOperation constructor(value: InvocationOperation) : JsSyntax("new $value")