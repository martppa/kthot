package net.asere.kotlin.js.dsl.syntax.operational.logical.comparison

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.logical.operator.LogicalOperator
import net.asere.kotlin.js.dsl.type.bool.JsBoolean

abstract class LogicalComparison : CompoundOperation(), JsBoolean {
    abstract override val operator: LogicalOperator
}