fun main(args: Array<String>) {
    val countingSetKotlin = CountingSetKotlin()
    countingSetKotlin.addAll(setOf(1, 2, 3))
    println(countingSetKotlin.getCount())
    val countingSetKoltinNativeDelegation = CountingSetKoltinNativeDelegationV1()
    countingSetKoltinNativeDelegation.addAll(setOf(1, 2, 3, 4))
    println(countingSetKoltinNativeDelegation.count)

}

class CountingSetKotlin : HashSet<Long>() {
    private var count: Int = 0;

    override fun add(element: Long): Boolean {
        count++;
        return super.add(element)
    }

    override fun addAll(elements: Collection<Long>): Boolean {
        count += elements.size
        return super.addAll(elements)
    }

    fun getCount() = count
}

class CountingSetKoltinNativeDelegationV1(private val delegate: MutableSet<Long> = HashSet()) : MutableSet<Long> by delegate {
    var count = 0
    override fun add(element: Long): Boolean {
        count++
        return delegate.add(element)
    }

    override fun addAll(elements: Collection<Long>): Boolean {
        count += elements.size
        return delegate.addAll(elements)
    }
}

class CountingSetKoltinNativeDelegationV2 : MutableSet<Long> by HashSet() {
    var count: Int = 0

    override fun add(element: Long): Boolean {
        count++
        return add(element)
    }

    override fun addAll(elements: Collection<Long>): Boolean {
        count += count + elements.size
        return addAll(elements)
    }

}
