fun main(args: Array<String>) {
    val countingSet = CountingSet()
    countingSet.addAll(hashSetOf(1,2,3))
    println(countingSet.addedCount)

    val sub = JavaSubClass()
    println(sub.name)

}

