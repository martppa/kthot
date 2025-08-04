package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSType

val KSType.definitionName: String get() {
    val baseDeclaration = this.declaration
    val baseName = baseDeclaration.name

    if (this.arguments.isNotEmpty()) {
        val argumentNames = this.arguments.joinToString(separator = ", ") { arg ->
            val argumentType = arg.type?.resolve()
            argumentType?.definitionName ?: "???"
        }
        return "$baseName<$argumentNames>"
    }

    return baseName
}

fun KSType.getBoundsTypes(): Set<KSType> {
    val types: MutableSet<KSType> = mutableSetOf()
    fun getInnerBoundsType(type: KSType) {
        type.arguments.forEach { argument ->
            argument.type?.resolve()?.let { types.add(it) }
            argument.type?.resolve()?.let { getInnerBoundsType(it) }
        }
    }
    if (this.arguments.isNotEmpty()) {
        arguments.forEach { argument -> argument.type?.resolve()?.let { types.add(it) } }
    }
    return types
}