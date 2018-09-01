fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
    println(lazyUnsynchronizedValue)
}

// lazy is a builtin delegate. by default its synchronized
// lazy is equivalent to lazy(LazyThreadSafetyMode.SYNCHRONIZED)
val lazyValue: String by lazy {
    println("Synchronized computed!")
    "Hello"
}

val lazyUnsynchronizedValue : String by lazy(LazyThreadSafetyMode.PUBLICATION) {
    println("Unsynchronized computed!")
    "Hello"
}

