package net.asere.kthot.js.dsl.syntax.operational.equality.operator

object NotStrictEquals : EqualityOperator() {
    override val _value_: String = " !== " // TODO: Implement a dynamic spacing solution
}