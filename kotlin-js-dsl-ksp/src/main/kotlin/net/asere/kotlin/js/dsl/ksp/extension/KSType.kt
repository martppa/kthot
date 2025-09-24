package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSType

/**
 * The definition name includes all generic type parameters and its types
 */
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

/**
 * Returns true or false whether this type has generic arguments
 */
fun KSType?.hasArgumentsTypes(): Boolean = this?.getArgumentsTypes()?.isNotEmpty() ?: false

/**
 * Returns the list of type's generic arguments types
 */
fun KSType.getArgumentsTypes(): Set<KSType> {
    val types: MutableSet<KSType> = mutableSetOf()
    arguments.forEach { argument -> argument.type?.resolve()?.let { types.add(it) } }
    return types
}

/**
 * Get all generic types, including bounding types of generic types
 * and bounding types of those as well, recursively.
 */
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

/**
 * Creates a name for a generic type builder
 */
val KSType.builderName: String get() = "${declaration.name.replaceFirstChar { it.lowercase() }}Builder"

/**
 * Creates a definition for a generic type builder following a syntax builder pattern.
 */
fun KSType.getBuilderDefinition(argument: KSClassDeclaration) =
    "${declaration.name.replaceFirstChar { it.lowercase() }}Builder: (${argument.asStarProjectedType().definitionName}, isNullable: Boolean) -> $definitionName"