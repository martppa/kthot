package net.asere.kthot.js.dsl.syntax.operational.equality.comparison

import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kthot.js.dsl.type.bool.JsBoolean

abstract class EqualityComparison : CompoundOperation(), JsBoolean {
    abstract override val operator: EqualityOperator
}