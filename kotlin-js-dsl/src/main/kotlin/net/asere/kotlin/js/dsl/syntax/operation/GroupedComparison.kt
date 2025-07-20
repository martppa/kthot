package net.asere.kotlin.js.dsl.syntax.operation

class GroupedComparison<T : Operation>(
    nested: T
) : Operation() {
    override val value: String = "($nested)"
}

fun <T : Operation> T.group(): GroupedComparison<T> = GroupedComparison(this)

fun Operable.groupIfComparison() = if (this is Operation) this.group() else this