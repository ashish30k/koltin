fun main(args: Array<String>) {
    val list = arrayListOf("One", "Three", "Five")
    var delegatingCollection = DelegatingCollection<String>(list)
    println(delegatingCollection.size)
    println(delegatingCollection.containsAll(arrayListOf("One")))

    val list1 = arrayListOf("Ashish", "Shubhi")
    val koltinNativeDelegatingCollection = KoltinNativeDelegatingCollection(list1)
    println(koltinNativeDelegatingCollection.size)
    println(koltinNativeDelegatingCollection.containsAll(arrayListOf("Ashish")))


}

class DelegatingCollection<T>(private val innerList: ArrayList<T>) : Collection<T> {
    override val size: Int
        get() {
            println("DelegatingCollection size property gets called by client")
            return innerList.size
        }

    override fun contains(element: T): Boolean {
        println("DelegatingCollection inside contains()")
        return innerList.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        println("DelegatingCollection inside containsAll()")
        return innerList.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        println("DelegatingCollection inside isEmpty()")
        return innerList.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        println("DelegatingCollection inside iterator()")
        return innerList.iterator()
    }
}

// No boiler plate code. Simply override methods whom you want to change behaviour
class KoltinNativeDelegatingCollection<T>(private val delegate: Collection<T> = ArrayList()) : Collection<T> by delegate {
    override val size: Int
        get() {
            println("KoltinNativeDelegatingCollection size property gets called by client")
            return delegate.size
        }

}