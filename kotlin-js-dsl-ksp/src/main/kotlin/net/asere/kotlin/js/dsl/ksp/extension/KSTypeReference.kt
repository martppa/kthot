package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import com.google.devtools.ksp.symbol.KSTypeReference
import net.asere.kotlin.js.dsl.ksp.processor.jsNullableAnnotationName

fun KSTypeReference?.isNullable(): Boolean = this?.annotations?.find {
    it.annotationType.resolve().declaration.qualifiedName?.asString() == jsNullableAnnotationName
} != null

fun KSTypeReference?.isSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.resolve()
    ?.declaration.isSubclassOf(classDeclaration)

val KSTypeReference.packageName: String get() = resolve().declaration.packageName.asString()

fun KSTypeReference?.isGenericTypeParameter(): Boolean {
    val resolvedType = this?.resolve() ?: return false
    return resolvedType.declaration is KSTypeParameter
}