import kotlin.properties.Delegates

fun main(args: Array<String>) {
    val user = User()
    user.name = "first"
    user.name = "second"

    user.age = -1
    user.age = 38

}

class User {
//    var name: String by Delegates.observable(initialValue = "<no name>") {
//        property, oldValue, newValue -> println("$oldValue -> $newValue")
//    }

//    var name: String by Delegates.observable(initialValue = "<no username>",onChange = {
//        property, oldValue, newValue ->  println("$oldValue -> $newValue")
//    })

    var name: String by Delegates.observable(
            "<no username>"
    ) { _, oldValue, newValue -> println("$oldValue -> $newValue") }

    var age: Int by Delegates.vetoable(23)
    { property, oldValue, newValue -> println("oldValue:$oldValue and newValue:$newValue")
        newValue >=1}
}

