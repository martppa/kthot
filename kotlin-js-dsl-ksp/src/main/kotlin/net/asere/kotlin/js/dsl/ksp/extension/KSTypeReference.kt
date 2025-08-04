package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeReference

fun KSTypeReference?.isSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.resolve()
    ?.declaration.isSubclassOf(classDeclaration)

val KSTypeReference.packageName: String get() = resolve().declaration.packageName.asString()