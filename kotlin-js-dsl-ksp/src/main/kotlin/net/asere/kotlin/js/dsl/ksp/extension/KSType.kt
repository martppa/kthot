package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSClassDeclaration
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

fun KSType?.hasArgumentsTypes(): Boolean = this?.getArgumentsTypes()?.isNotEmpty() ?: false

fun KSType.getArgumentsTypes(): Set<KSType> {
    val types: MutableSet<KSType> = mutableSetOf()
    arguments.forEach { argument -> argument.type?.resolve()?.let { types.add(it) } }
    return types
}

fun KSType.getAllTypes(): Set<KSType> {
    val types: MutableSet<KSType> = mutableSetOf(this)
    fun getInnerBoundsType(type: KSType) {
        type.arguments.forEach { argument ->
            argument.type?.resolve()?.let { types.add(it) }
            argument.type?.resolve()?.let { getInnerBoundsType(it) }
        }
    }
    arguments.forEach { argument -> argument.type?.resolve()?.let { types.add(it) } }
    return types
}

val KSType.builderName: String get() = "${declaration.name.replaceFirstChar { it.lowercase() }}Builder"
fun KSType.getBuilderDefinition(argument: KSClassDeclaration) =
    "${declaration.name.replaceFirstChar { it.lowercase() }}Builder: (${argument.asStarProjectedType().definitionName}) -> $definitionName"