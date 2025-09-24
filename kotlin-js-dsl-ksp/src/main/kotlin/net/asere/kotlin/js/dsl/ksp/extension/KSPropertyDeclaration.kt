package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeParameter

/**
 * Package + name of the property's type
 */
val KSPropertyDeclaration.typeFullName: String get() = type.resolve().declaration.qualifiedName?.asString() ?: "Any"

/**
 * Package + basic name of the property's type. The basic name is the name of type, which is not a helper. Helpers
 * are reference, syntax or value classes. For example, JsNumberRef is the reference helper of JsNumber.
 */
val KSPropertyDeclaration.basicTypeFullName: String get() = type.resolve().declaration.qualifiedName?.asString()?.stripHelperSuffix() ?: "Any"

/**
 * The package of the property's type
 */
val KSPropertyDeclaration.typePackage: String get() = type.resolve().declaration.packageName.asString()

/**
 * The name of the type
 */
val KSPropertyDeclaration.typeName: String get() = type.resolve().declaration.simpleName.asString()

/**
 * Tells whether the property is JsElement
 */
fun KSPropertyDeclaration?.isJsElement(resolver: Resolver) = this?.type?.resolve()?.declaration.isJsElement(resolver)

/**
 * Whether the property's type is subclass of provided class declaration
 */
fun KSPropertyDeclaration?.isTypeSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.type.isSubclassOf(classDeclaration)

/**
 * Returns true or false whether the property's type has generic arguments
 */
fun KSPropertyDeclaration?.hasArgumentsTypes() =
    this?.type?.resolve()?.hasArgumentsTypes() ?: false

/**
 * Returns the list of property's type generic arguments types
 */
fun KSPropertyDeclaration?.getArgumentsTypes(): Set<KSType> {
    return this?.type?.resolve()?.getArgumentsTypes() ?: setOf()
}

/**
 * Whether the property's type is a generic type
 */
fun KSPropertyDeclaration?.isGenericTypeParameter(): Boolean {
    val resolvedType = this?.type?.resolve() ?: return false
    return resolvedType.declaration is KSTypeParameter
}