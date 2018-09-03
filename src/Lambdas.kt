import java.io.File

fun main(args: Array<String>) {
    val list = listOf(Person4("John", 32), Person4("Tim", 28), Person4("Joe", 27), Person4("James", 25), Person4("Tommy", 32))
    println(list.sortedBy { it.age }.last())
    println(list.maxBy { it.age })
    println(list.maxBy() { person4: Person4 -> person4.age })
    // if lambda just delegates to function or property, it can be replaced by a member reference
    println(list.maxBy(Person4::age))
    println(list.joinToString(separator = ",", transform = { it.name }))
    println(list.joinToString(",") { it.name })
    printMessagesWithPrefix(listOf("404-Not Found", "403-Forwidden"), "Error")

    println(list.filter { it.age > 26 }.map { it.name })

    val numbers = listOf(1, 2, 3)
    println(numbers.map { it * it })
    val maxAge = list.maxBy { it.age }?.age
    println(list.filter { it.age == maxAge }.map { it.name })

    println(list.any { it.age >= 26 })

    println(list.all { it.age >= 25 })

    println(list.filter { it.age == 32 }.count())

    println(list.filter { it.age == 32 }.firstOrNull())

    println(list.groupBy { it.age }.mapKeys { it.key + 1 })

    println(list.groupBy { it.age }.mapValues { it.value })

    val strings = listOf("a", "ab", "b")
    println(strings.groupBy { it.first() })
    println(strings.groupBy(String::first))


    val books = listOf(Book("Kotlin", listOf("Author A", "Author B")),
            Book("RxJava", listOf("Author A", "Author C")))

    println(books.flatMap { book: Book -> book.authors }.toSet())
    println(books.flatMap { it.authors }.toSet())

    println(strings.flatMap { it.toList() })

    println(strings.flatMap { it.toUpperCase().toList() })

    val listOfLists = listOf(listOf("One", "Two"), listOf("Three"))
    println(listOfLists.flatten())

    // list of all persons whom name starts with 'J'
    println(list.map { it.name }.filter { it.startsWith("J") })

    println(list.asSequence()
            .map { it.name }
            .filter { it.startsWith("J") }
            .toList())

    println(list.asSequence()
            .map { it.name }
            .filter { it.startsWith("J") }
            .toMutableList().add("Johnny"))

    println(list.asSequence()
            .map { it.name }
            .filter { it.startsWith("J") })

    numbers.asSequence()
            .map {
                print("map($it)"); it * it
            }
            .filter {
                print("filter($it)"); it % 2 == 0
            }
            .toList()
    println()
    numbers.map { print("map($it)"); it * it }
            .filter { print("filter($it)"); it % 2 == 0 }

    println()
    println(numbers.asSequence()
            .map {
                print("map($it)"); it * it
            }
            .filter {
                print("filter($it)"); it % 2 == 0
            }.find { print("find($it)"); it > 3 })

    println()
    println(numbers.map { print("map($it)"); it * it }
            .filter { print("filter($it)"); it % 2 == 0 }
            .find { print("find($it)");it > 3 })

    println()
    println(numbers.map { print("map($it)"); it * it }
            .find { print("find($it)"); it > 3 })

    println()
    println(numbers.asSequence().map { print("map($it)"); it * it }
            .find { print("find($it)"); it > 3 })

    // print names of persons if they are shorter then a certain limit
    println()
    println(list.map { print("map(${it.name})");it.name }
            .filter { print("filter($it)");it.length < 3 })

    println()
    println(list.filter { print("filter(${it.name})"); it.name.length < 3 }
            .map { print("map($it)");it.name })

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    val file = File("/Users/ashishkumar/.gradle/daemon/2.2.1/daemon-1726.out.log")
    println(file.absoluteFile)
    println(file.isInsideHiddenDirectory())

    val file1 = File("/Users/ashishkumar/hello.jar")
    println(file1.canonicalFile)
    println(file1.isInsideHiddenDirectory())


    val javaClient = JavaClient()
    javaClient.postponeComputation(1000) { println("Computation by Lambda") }

    javaClient.postponeComputation(1000, object : Runnable {
        override fun run() {
            println("Computation by object")
        }
    })

    val runnable = Runnable { println("abc") }
    javaClient.postponeComputation(1000, runnable)

    val runnableObject = object : Runnable {
        override fun run() {
            println("abc")
        }
    }

    javaClient.postponeComputation(1000, runnableObject)
    handleComputation("Print Command")

    println(alphabetWithReceiver())

}

fun handleComputation(command: String) {
    val javaClient = JavaClient()
    javaClient.postponeComputation(1000) { println(command) }
}

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All Done") } // SAM constructor
}

/*
val listener = OnClickListener { view ->
    val text = when(view.id)
        R.id.button1 -> "First Button"
                        R.id.button2 -> "Second Button"
    else -> "Unknown Button"

    toast(text)

}

button1.setOnClickListener(listener)
button2.setOnClickListener(listener)
*/


fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    return result.toString()
}

fun alphabetWithReceiver(): String {
    val result = StringBuilder()
    with(result) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        return toString()
    }
}

fun alphabetWithReceiver2(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        toString()
    }
}

fun alphabetWithReceiver3() =
        with(StringBuilder()) {
            for (letter in 'A'..'Z') {
                append(letter)
            }
            toString()
            // this@OuterClass.toString()
        }

fun alphabetWithReceiver4() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
}.toString()

fun alphabet2() = buildString {
    for(letter in 'A'..'Z') {
        append(letter)
    }
}


fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach { println("$prefix $it") }
}

data class Book(val title: String, val authors: List<String>)


