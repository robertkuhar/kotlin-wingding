package other_dec_13.typealiases

data class Manufacturer(val name: String)

data class Car(val make: Manufacturer, val model: String, val year: Int)

typealias CarSet = Set<Car>

typealias OscarWinners = Map<String, String>
fun countLaLaLand(oscarWinners: OscarWinners) =
        oscarWinners.count { it.value.contains("La La Land") }

// Note that the type names (initial and the type alias) are interchangeable:
fun checkLaLaLandIsTheBestMovie(oscarWinners: Map<String, String>) =
        oscarWinners["Best picture"] == "La La Land"

class A {
    inner class Inner
}

class B {
    inner class Inner
}
// This is of dubious value...
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

