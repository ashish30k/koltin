import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val example = Example()
    println(example.p1)
    example.p1 = "Delegate"
    example.p2 = "DelegateImplementation"
}

class Example {
    var p1: String by Delegate()
    var p2 : String by DelegateImplementation()
}

class Delegate{
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("'$value' has been assigned to '${property.name}' in $thisRef")
    }
}


class DelegateImplementation: ReadWriteProperty<Any?,String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("'$value' has been assigned to '${property.name}' in $thisRef")
    }

}