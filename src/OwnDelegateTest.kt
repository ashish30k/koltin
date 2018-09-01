// Implementing delegation with interface and composition without native support
fun main(args: Array<String>) {
    printArea(Square(5.0))
    printArea(Rectangle(4.0, 5.0))
}

interface Shape {
    fun area(): Double
}

class Rectangle(val height: Double, val width: Double) : Shape {
    override fun area() = height * width
}

class Square(val d: Double) : Shape {
    val rectangle = Rectangle(d, d)
    override fun area() = rectangle.area()
}

fun printArea(shape: Shape) {
    println(shape.area())
}