package net.asere.kthot.js.dsl.syntax.operational.logical.comparison.operator

import net.asere.kthot.js.dsl.syntax.operational.logical.operator.LogicalOperator

object And : LogicalOperator() {
    override val value: String = " && "  // TODO: Implement a dynamic spacing solution
}