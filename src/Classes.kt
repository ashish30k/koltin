fun main(args: Array<String>) {
    val user4 = User4("Ashish")
    user4.address = "8568 Warren"
    val user5 = User5()
    val twitterUser = TwitterUser("Twitter Name")

    val string = "Ashish12345"
    println(string.takeLast(4))

    println(string.filter { it.isLetter() })

    println(string)

    val person1 = Person1("Ashish", "Kumar", 162.00)

    println(person1.fullName)

    person1.name = "Shubhi"
    person1.lastName = "Gupta"

    println(person1.fullName) // Here full name will still be Ashish Kumar becuase fullName is stored once during object creation
    //In order to avoid this issue we have to define custom getter that will calculate fullName everytime this property is accessed

    val person7 = Person7("KumarAshish.knit@gmail.com")
    println("Person7 email: ${person7.email}")
    println("Person7 nickname: ${person7.nickName}")

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Word")
    println(lengthCounter.length)
}


class User2 constructor(_name: String) {
    private val name: String

    init {
        name = _name
    }
}

// You can omit constructor keyword for primary one if there are no visibility modifiers or annotations
class User3 constructor(val name: String)

// property is generated for the construction parameter
open class User4(val name: String) {
    var address: String = "unspecified"
    set(value:String) {
        println("the address for $name changed from $field -> $value")
    }
}


// If u specify default values for all constructor params then Koltin generates a empty constructor.
//That makes it easier to use Koltin with libraries that instantiate classes via parameterless constructors
class User5(val name: String = "Default name")

// If your class has superclass, the primary constructor also needs to initialize the superclass.
class TwitterUser(name: String) : User4(name) {
    /*fun getTwitterId()= name+"@twitter.com"*/ // templates are preffered over concatenation
    fun getTwitterId() = "$name@twitter.com"
}

// In java, you can use a private constructor that prohibits class instantiation to express more general idea: that the class is a
// container of static utility members or is a singlton. Kotlin has build-in language features for these purposes.
// You use top level functions as static utilities.
// You use object declarations to express singltons.
class PrivateClass private constructor() {

}

// If the class has no primary constructor then each secondary constructor has to initialize base class or delegates to
// another constructor that does so.

// Implementing properties declared in interfaces
// In kotlin an interface can contain abstract property declarations.

interface User6 {
    val nickName: String
}

class PrivateUser(override val nickName: String) : User6

class SubscribingUser(val email: String) : User6 {
    override val nickName: String
        get() = email.substringBefore("@")
}

class FacebookUser(val facebookId: String) : User6 {
    override val nickName = getFacebookNickName(facebookId)

    private fun getFacebookNickName(facebookId: String) = "Ashish"
}

// referenec https://blog.kotlin-academy.com/kotlin-should-i-define-function-or-property-6786951da909
/**
 * There were a few good reasons why Kotlin introduces properties. One of them is property access syntax
 * (we use height instead of getHeight/setHeight) which is more concise,
 * another is the fact that getters and setters are closer to property declaration,
 * unlike Java where usually we put property at the top of the class and getter/setter at the bottom.
 * My favorite feature are property delegates that increase the ability to reuse the code.
 * We can initialize a variable when it is needed (lazy delegate),
 * perform some action whenever the property value is changed (observable delegate)
 * or simply store our property in another object (Android shared preferences, map, browser session, database…) using a custom delegate.
 */


// Good thing is that Kotlin allows us to use both functions (technically methods) and properties in the interfaces.

/**
 * There is also additional set of guidelines (coming from Effective Java If I remember correctly)
 * helping us to tell if property is preferred over function:
 * does not throw exception
 * is cheap to calculate (or cached on the first run)
 * returns the same result over multiple invocations
 */

class Person1(var name: String, var lastName: String, var weight: Double) {
    // val fullName: String = "$name $lastName" // this will be evaluated only once when creating Person1 object

    val fullName: String
        get() = "$name $lastName" // This custom accessor code block will be executed every time fullName is accessed.

    fun jump() {
        weight -= .1
    }

    fun run() {

    }

    fun walk() {

    }

}

interface User7 {
    val email: String
    val nickName: String
    get() = email.substringBefore("@")
}

class Person7(override val email: String) : User7 {
    override val nickName: String = email.substringBefore("@")+ " Person"
}

// Changing visibility of accessors
// By default visibility of accessors(getters or setters) is same as property's visibility
class LengthCounter {
    var length: Int = 0
    private set

    fun addWord(word: String) {
        length += word.length
    }
}