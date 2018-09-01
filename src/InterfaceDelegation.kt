fun main(args: Array<String>) {

// Interface delegation  is a very powerful tool to achieve a cleaner composition
// If an object is composed by other components, it’d be very good that it could use their functions directly.
// Favor composition over inheritance
// be used with properties as well. I will just focus on class delegation in this post.
//Kotlin also has some other language features to “reduce” the use of inheritance,
// like typealias for tagging classes and class are final by default.

    // Language-level feature that allows an object designate another one as its “parent” is called Implicitly Delegation.
    // It, in particular, is divided into unanticipated delegation and anticipated delegation.
    // Case, when delegation structure can be changed dynamically, is called unanticipated,
    // whereas the second type refers to the fact that object can’t change parent during their life-cycle.

}

interface A {
    fun function1() {

    }
}

interface B {
    fun function2() {

    }
}

class C : A, B {
    fun function() {
        function1()
        function2()
    }
}

class C1(val a: A, val b: B) {
    fun function() {
        a.function1()
        b.function2()
    }
}

class C2(a: A, b: B) : A by a, B by b {
    fun function() {
        function1()
        function2()
    }
}