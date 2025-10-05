package net.asere.kthot.js.dsl.syntax.operational.equality.operator

object NotStrictEquals : EqualityOperator() {
    override val value: String = " !== " // TODO: Implement a dynamic spacing solution
}