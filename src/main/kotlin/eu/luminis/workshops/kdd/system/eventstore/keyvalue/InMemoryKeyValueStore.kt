package eu.luminis.workshops.kdd.system.eventstore.keyvalue

class InMemoryKeyValueStore<K, V>(initialEntries: Map<K, V> = mapOf()) : KeyValueStore<K, V> {
    private val store: MutableMap<K, V> = initialEntries.toMutableMap()

    override fun get(key: K): V? = store[key]

    override fun put(key: K, value: V) {
        store[key] = value
    }
}