package net.asere.kthot.js.dsl.provider

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

private val beacons: MutableMap<String, Beacon> = mutableMapOf()

inline fun <reified T : Any> register(
    noinline builder: (JsElement) -> T
) {
    val key = T::class.java.name
    register(key = key, builder = builder)
}

fun register(key: String, builder: (JsElement) -> Any) {
    beacons[key] = buildBeacon(builder)
}

fun provide(key: String, value: JsElement): Any {
    val beacon = beacons[key]
        ?: throw ProviderNotFoundException(key)
    return beacon.invoke(value)
}

inline fun <reified T> provide(element: JsElement): T {
    val key = T::class.java.name
    return provide(key, element) as T
}

inline fun <reified T : JsReference<C>, reified C : JsValue> provide(element: T): C {
    val key = C::class.java.name
    return provide(key, element) as C
}

private fun buildBeacon(builder: (JsElement) -> Any): Beacon {
    return Beacon(builder)
}