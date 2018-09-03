fun main(args: Array<String>) {

    val subscribingUser = User8.getSubscribingUser("kumarashish")
    val facebookUser = User8.Companion.getFacebookUser("ashsih.kga123@facebook.com") // you can also use Companion but not needed

    println(subscribingUser.nickName)
    println(facebookUser.nickName)

    println(Person2.Loader.fromJson("json string"))
    println(loadFromJSON(Person3))

    println(Person4.fromJson("jsontext"))

}

// Companion object for factory methods which does not require object intsance to be invoked and can also access internals of the class
// including private constructor.

class User8 private constructor(val nickName: String) {

    // optionally you can also give name to companion object
    // dafault name is  Companion
    companion object  {
        fun getSubscribingUser(emailId: String) = User8(emailId.substringBefore("@"))

        fun getFacebookUser(facebookId: String) = User8(getFacebookName(facebookId))

    }
}

private fun getFacebookName(facebookId: String) = "ashish"

// Companion objects as regular objects
// It can be named, implement an interface, or have extension functions or properties

class Person2(val name:String) {
    companion object Loader{
        fun fromJson(jsonText:String) = Person2(parseJson(jsonText))

        private fun parseJson(jsonText: String) = "Person's name"
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person3(val name: String) {
    companion object : JSONFactory<Person3>{
       @JvmStatic override fun fromJSON(jsonText: String): Person3 {
            return Person3("Person's Name")
        }
    }

}

fun <T> loadFromJSON(factory: JSONFactory<T>) : T {
    return factory.fromJSON("jsonText")
}

// seperate deserialization from core Person buisness logic

data class Person4(val name: String, val age:Int) {
    companion object {

    }
}