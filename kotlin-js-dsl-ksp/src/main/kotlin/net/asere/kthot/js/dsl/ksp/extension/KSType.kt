package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kthot.js.dsl.ksp.processor.jsElementName
import net.asere.kthot.js.dsl.type.reference.ReferenceId

/**
 * The definition name includes all generic type parameters and its types, e.g: JsPromise<JsArray<JsString>>
 */
val KSType.definitionName: String get() {
    val baseDeclaration = this.declaration
    val baseName = baseDeclaration.name

    if (this.arguments.isNotEmpty()) {
        val argumentNames = this.arguments.joinToString(separator = ", ") { arg ->
            val argumentType = arg.type?.resolve()
            argumentType?.definitionName ?: "*"
        }
        return "$baseName<$argumentNames>"
    }

    return baseName
}

/**
 * The definition types of all generic type parameters and its types, e.g: <JsArray<JsString>>
 */
val KSType.definitionTypes: String get() {
    val baseName = ""

    if (this.arguments.isNotEmpty()) {
        val argumentNames = this.arguments.joinToString(separator = ", ") { arg ->
            val argumentType = arg.type?.resolve()
            argumentType?.definitionName ?: "*"
        }
        return "<$argumentNames>"
    }

    return baseName
}

/**
 * The definition types of all generic type parameters and its types replacing TyeParameters as JsObject,
 * e.g, in <JsArray<T>> would be: <JsArray<JsObject>>
 */
val KSType.definitionTypesAsJsGenerics: String get() {
    val baseName = ""

    if (this.arguments.isNotEmpty()) {
        val argumentNames = this.arguments.joinToString(separator = ", ") { arg ->
            val argumentType = arg.type?.resolve()
            if (argumentType?.isGenericType == true) {
                val declaration = argumentType.declaration as KSTypeParameter
                if (declaration.bounds.toList().isEmpty()) {
                    "JsGenerics"
                } else {
                    declaration.bounds.first().resolve().definitionName
                }
            } else {
                argumentType?.let {
                    "${it.declaration.jsName}${it.definitionTypesAsJsGenerics}"
                } ?: "*"
            }
        }
        return "<$argumentNames>"
    }

    return baseName
}

/**
 * The basic definition name includes all generic type parameters and its types
 */
val KSType.basicDefinitionName: String get() {
    val baseDeclaration = this.declaration
    val baseName = baseDeclaration.basicJsName

    if (this.arguments.isNotEmpty()) {
        val argumentNames = this.arguments.joinToString(separator = ", ") { arg ->
            val argumentType = arg.type?.resolve()
            argumentType?.basicDefinitionName ?: "*"
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
val KSType.builderName: String get() = if (declaration.typeParameters.isEmpty())
    "_${declaration.name.replaceFirstChar { it.lowercase() }}Builder_"
else
    "_${getAllTypes().joinToString("") {
        it.declaration.jsName
    }.replaceFirstChar { it.lowercase() }}Builder_"

/**
 * Creates a definition for a generic type builder lambda following a syntax builder pattern.
 */
fun KSType.getBuilderDefinition(argument: KSClassDeclaration) =
    "$builderName: (${argument.asStarProjectedType().definitionName}) -> $definitionName"

/**
 * Returns the parameters as a list of parameters definition, e.g jsString: JsString, jsValue: JsValue,
 * if the parameter has no name a random one will be provided
 */
fun KSType.getTypesAsParametersDefinition() = arguments.joinToString { "${it.type?.resolve()?.declaration?.jsName?.replaceFirstChar { char -> char.lowercase() } ?: "p${ReferenceId.nextRefInt()}"} : ${it.type}" }

val KSType.isGenericType: Boolean get() = declaration is KSTypeParameter

fun KSType.isJsElement(resolver: Resolver): Boolean = declaration.isJsElement(resolver)

/**
 * Checks if the given KSType represents a function signature of the form
 * (JsElement) -> T, where T is any return type.
 *
 * @return True if the type matches the pattern, false otherwise.
 */
val KSType.isBuilderFunction: Boolean get() {
    val FUNCTION1_QUALIFIED_NAME = "kotlin.Function1"

    val JSELEMENT_QUALIFIED_NAME = jsElementName

    val isFunction1 = declaration.qualifiedName?.asString() == FUNCTION1_QUALIFIED_NAME
    if (!isFunction1) {
        return false
    }

    val typeArguments = arguments

    if (typeArguments.size != 2) {
        return false
    }

    val parameterTypeReference = typeArguments[0].type
    if (parameterTypeReference == null) {
        return false
    }

    val parameterType = parameterTypeReference.resolve()
    val parameterQualifiedName = parameterType.declaration.qualifiedName?.asString()

    return parameterQualifiedName == JSELEMENT_QUALIFIED_NAME
}