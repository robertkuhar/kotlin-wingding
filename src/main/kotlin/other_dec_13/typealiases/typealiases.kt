package other_dec_13.typealiases

data class Manufacturer(val name: String)

data class Car(val make: Manufacturer, val model: String, val year: Int)

typealias CarSet = Set<Car>

class A {
    inner class Inner
}

class B {
    inner class Inner
}

typealias AInner = A.Inner

typealias BInner = B.Inner

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

fun main(args: Array<String>) {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"
    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // prints "[1]"
}

