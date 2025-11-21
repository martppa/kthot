package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeParameter
import com.google.devtools.ksp.symbol.KSTypeReference
import net.asere.kthot.js.dsl.ksp.processor.jsNullableAnnotationName

/**
 * Tells if the reference is null
 */
fun KSTypeReference?.isNullable(): Boolean = this?.annotations?.find {
    it.annotationType.resolve().declaration.qualifiedName?.asString() == jsNullableAnnotationName
} != null

/**
 * Tells if the reference is subclass of the provided class declaration
 */
fun KSTypeReference?.isSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.resolve()
    ?.declaration.isSubclassOf(classDeclaration)

/**
 * Package of the type reference
 */
val KSTypeReference.packageName: String get() = resolve().declaration.packageName.asString()

/**
 * Whether the type reference is a generic type.
 */
fun KSTypeReference?.isGenericTypeParameter(): Boolean {
    val resolvedType = this?.resolve() ?: return false
    return resolvedType.declaration is KSTypeParameter
}

/**
 * Recursively collects all KSTypes from a starting type reference, including
 * all nested generic types.
 *
 * @param collectedTypes The mutable set to store the collected types.
 */
fun KSTypeReference.collectTypesRecursively(
    collectedTypes: MutableSet<KSType>
) {
    val type = resolve()
    collectedTypes.add(type)

    for (argument in type.arguments) {
        val argumentTypeReference = argument.type
        argumentTypeReference?.collectTypesRecursively(collectedTypes)
    }
}

val KSTypeReference.isBuilderFunction: Boolean get() = resolve().isBuilderFunction