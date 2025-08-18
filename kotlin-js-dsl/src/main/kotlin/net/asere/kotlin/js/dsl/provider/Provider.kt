package net.asere.kotlin.js.dsl.provider

private val beacons: MutableMap<String, Beacon> = mutableMapOf()
fun key(clazz: String, name: String) = "${clazz}__$name"

inline fun <reified T : Any> register(
    name: String = String.empty(),
    singleton: Boolean = false,
    noinline creator: () -> T
) {
    val key = key(T::class.java.name, name)
    registerWithKey(key = key, singleton = singleton, creator = creator)
}

fun registerWithKey(key: String, singleton: Boolean, creator: () -> Any) {
    beacons[key] = buildBeacon(creator, singleton)
}

fun provideWithKey(key: String): Any {
    val beacon = beacons[key]
        ?: throw BeaconNotFoundException(key)
    return beacon.invoke()
}

inline fun <reified T> provide(name: String = String.empty()): T {
    val key = key(T::class.java.name, name)
    return provideWithKey(key) as T
}

private fun buildBeacon(creator: () -> Any, singleton: Boolean): Beacon {
    return if (singleton) {
        SingleBeacon(creator)
    } else {
        Beacon(creator)
    }
}
