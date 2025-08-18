package net.asere.kotlin.js.dsl.provider

class BeaconNotFoundException(identifier: String)
    : Exception("No definition found for $identifier")