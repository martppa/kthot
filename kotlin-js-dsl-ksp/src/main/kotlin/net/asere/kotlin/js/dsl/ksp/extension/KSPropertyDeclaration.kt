package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSType

val KSPropertyDeclaration.typeFullName: String get() = type.resolve().declaration.qualifiedName?.asString() ?: "Any"
val KSPropertyDeclaration.typePackage: String get() = type.resolve().declaration.packageName.asString()
val KSPropertyDeclaration.typeName: String get() = type.resolve().declaration.simpleName.asString()
fun KSPropertyDeclaration?.isJsElement(resolver: Resolver) = this?.type?.resolve()?.declaration.isJsElement(resolver)
fun KSPropertyDeclaration?.isTypeSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.type.isSubclassOf(classDeclaration)

fun KSPropertyDeclaration?.hasGenericTypes() =
    this?.type?.resolve()?.hasGenericTypes() ?: false

fun KSPropertyDeclaration?.getGenericTypes(): Set<KSType> {
    return this?.type?.resolve()?.getTypesOfGenericTypes() ?: setOf()
}