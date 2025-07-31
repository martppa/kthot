package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSPropertyDeclaration

val KSPropertyDeclaration.typeFullName: String get() = type.resolve().declaration.qualifiedName?.asString() ?: "Any"
val KSPropertyDeclaration.typeName: String get() = type.resolve().declaration.simpleName.asString()
val KSPropertyDeclaration.name: String get() = simpleName.asString()