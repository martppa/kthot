package net.asere.kotlin.js.dsl.provider

class ProviderNotFoundException(identifier: String)
    : Exception(
    "No definition found for $identifier. Make sure you have initialized the dsl. If you did, please make" +
        "sure the object you are trying to provide is a basic type and not a reference and has no type " +
        "parameters. You must provide your own builder for types with type parameters."
    )