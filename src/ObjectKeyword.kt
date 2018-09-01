import java.io.File

fun main(args: Array<String>) {
    // The object keyword defines a class and creates an instance of that calss at the same time
    // Object declaration is a way to define a singleton
    // Companion objects can contain factory methods and otehr methods that are related
    // to this class bit do not require a class instance to be called
    // Object expression is used instead of Java's anonymous inner class

    PayRoll.employeesList.addAll(arrayListOf("Ashish"))
    PayRoll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("/user"), File("/User")))

    println(CaseInsensitiveFileComparator.compare(File("/Z"), File("/a")))

    val filesList = listOf(File("/Z","/a"))
    println(filesList.sortedWith(CaseInsensitiveFileComparator))

}

// Object declarations: Singleton

object PayRoll {
    val employeesList = arrayListOf<String>()
    fun calculateSalary() {
        for (employee in employeesList) {
            //calculate salary
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {

    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}



