import java.io.File

data class Person(val name: String) {
    object NameCompartor : Comparator<Person> {
        override fun compare(p1: Person, p2: Person) = p1.name.compareTo(p2.name)
    }
}

fun main(args:Array<String>) {
    val persons = listOf(Person("1234"),Person("123"))
    println(persons.sortedBy { it.name })
    println(persons.sortedByDescending { it.name })
    println(persons.sortedWith(Person.NameCompartor))
}

object CaseInsenstiveFileCompartor : Comparator<File> {

    override fun compare(file1: File, file2: File) = file1.path.compareTo(file2.path,ignoreCase = true)
}


