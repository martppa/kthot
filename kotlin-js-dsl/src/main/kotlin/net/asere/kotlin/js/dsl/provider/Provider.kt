package net.asere.kotlin.js.dsl.provider

import net.asere.kotlin.js.dsl.type.JsElement

private val beacons: MutableMap<String, Beacon> = mutableMapOf()

inline fun <reified T : Any> register(
    noinline builder: (JsElement, Boolean) -> T
) {
    val key = T::class.java.name
    register(key = key, builder = builder)
}

fun register(key: String, builder: (JsElement, Boolean) -> Any) {
    beacons[key] = buildBeacon(builder)
}

fun provide(key: String, value: JsElement, isNullable: Boolean): Any {
    val beacon = beacons[key]
        ?: throw ProviderNotFoundException(key)
    return beacon.invoke(value, isNullable)
}

inline fun <reified T> provide(element: JsElement, isNullable: Boolean): T {
    val key = T::class.java.name
    return provide(key, element, isNullable) as T
}

private fun buildBeacon(builder: (JsElement, Boolean) -> Any): Beacon {
    return Beacon(builder)
}