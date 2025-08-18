package net.asere.kotlin.js.dsl.provider

class SingleBeacon(builder: () -> Any) : Beacon(builder) {
    private var value: Any? = null;
    override operator fun invoke(): Any {
        if (value == null) value = super.invoke()
        return value!!;
    }
}