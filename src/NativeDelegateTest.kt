fun main(args: Array<String>) {
val base = BaseImpl(10)
    val derived = Derived(base)
    derived.printMessage()
    derived.printMessageLine()
}

interface Shape1 {
    fun area(): Double
}

class Rectangle1( val height: Double,  val width: Double) : Shape1 {
    override fun area() = height * width
}

class Square1(val d: Double) : Shape1 by Rectangle1(d,d)

interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int): Base {
    override fun printMessage() {
        print(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived(base: Base):Base by base {
    override fun printMessage() {
        print("abc")
    }
}



