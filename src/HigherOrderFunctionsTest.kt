fun main(args: Array<String>) {
    val list = arrayListOf(4, 9, 8, 3, 12, 0)
    println(list.filterOnCondition { isMultipleOf(it, 4) })
    println(list.filterOnCondition { it -> it%4 == 0 })
    println(list.filterOnCondition { it%4 == 0  })
    println(list.filterOnCondition { int:Int -> int%4 == 0 })


    val listOfStr = arrayListOf<String>()
    listOfStr.add("Hello")
    listOfStr.add("World")
    listOfStr.add("How")
    listOfStr.add("are")
    listOfStr.add("you")

    println(listOfStr.filterOnCondition { it.contains("e") })

}

fun <T> ArrayList<T>.filterOnCondition(condition: (T) -> Boolean): ArrayList<T> {
    val filteredlist = arrayListOf<T>()
    for (item: T in this) {
        if (condition(item)) {
            filteredlist.add(item)
        }
    }
    return filteredlist
}

fun isMultipleOf(number: Int, multipleOf: Int) = (number % multipleOf) == 0

