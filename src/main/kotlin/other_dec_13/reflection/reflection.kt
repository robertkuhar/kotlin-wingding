package other_dec_13.reflection

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isOdd(x: Int) = x % 2 != 0
fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"

var x = 1

class A(val p: Int)

class MyClass {

}

fun main(args: Array<String>) {

    val c = MyClass::class
    println("simpleName: ${c.simpleName}")
    println("qualifiedName: ${c.qualifiedName}")

    val myClass = MyClass()
    println("myClass::class.simpleName: ${myClass::class.simpleName}")
    println("myClass::class.qualifiedName: ${myClass::class.qualifiedName}")

    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    fun length(s: String) = s.length

    val oddLength = compose(::isOdd, ::length)

    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength)) // Prints "[a, abc]"

    val predicate: (String) -> Boolean = ::isOdd // refers to isOdd(x: String)

    // Call through works...
    println("Call through works...")
    println("predicate(\"slithy\") produces ${predicate("slithy")}")
    println("oddLength(\"four\") produces ${oddLength("four")}")

    /*
     * The :: in first position when dealing with Properties led to almost universal confusion.
     * The docs this is covered under "Property References".  We were left wondering why it took
     * ::x::set to get the "handle" to the x Property's set function.
     */
    println("::x.get starts x: ${::x.get()}") // prints "1"
    println("yeah, but x: $x.  What am I missing?")
    ::x.set(2)
    println("::x.set makes x: $x") // prints "2"

    val beau = ::x::set
    beau(6)
    println("::x.set makes x: $x") // prints "6"

    x = 3
    println("yeah, but x: $x")

    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length)) // prints [1,2,3]

    // BobK:  This is "Constructor Reference".  I'm still confused.  What is return type of function?
    fun function(factory: () -> MyClass) {
        val x: MyClass = factory()
    }
    val mc = function(::MyClass)
    println("mc::class.simpleName: ${mc::class.simpleName}")
    println("mc::class.qualifiedName: ${mc::class.qualifiedName}")

    val prop = A::p
    println("the value of A(1) is: ${prop.get(A(1))}") // prints "the value of A(1) is: 1"
    println("the value of A(2) is: ${prop.get(A(2))}") // prints "the value of A(2) is: 2"

    // This is "Bound Function and Property References (since 1.1)"
    val numberRegex = "\\d+".toRegex()
    println("numberRegex.matches(\"29\") -> ${numberRegex.matches("29")}") // prints "true"
    val isNumber = numberRegex::matches
    println("isNumber(29) -> ${isNumber("29")}") // prints "true"
    println("isNumber(\"robert\") -> ${isNumber("robert")}") // prints "false"

    val moreStrings = listOf("abc", "124", "a70")
    println(moreStrings.filter(numberRegex::matches)) // prints "[124]"
}
