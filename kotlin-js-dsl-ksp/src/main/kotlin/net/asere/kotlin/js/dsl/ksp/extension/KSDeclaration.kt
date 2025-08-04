package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.closestClassDeclaration
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration

val KSDeclaration.fullName: String get() = qualifiedName?.asString() ?: "Any"
val KSDeclaration.name: String get() = simpleName.asString()

fun KSDeclaration?.isJsElement(resolver: Resolver): Boolean {
    val jsElementName = "net.asere.kotlin.js.dsl.JsElement"
    val jsElement = resolver.loadClass(jsElementName)
    return this.isSubclassOf(jsElement)
}

fun KSDeclaration?.isSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.closestClassDeclaration()
    ?.isSubclassOf(classDeclaration)
    ?: false

fun KSDeclaration.isAny() = qualifiedName?.asString() == "kotlin.Any"