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

    /*
     * BobK:  The :: syntax feels strange to me.  Why couldn't I have just used the function;s name here (Ex: isOdd)?
     * I'm obviously not calling it as that would be like isOdd(1).  The :: is feeling superfluous to me.
     *
     * Perhaps Kotlin's :: is like C's & unary operator (I think that is what that thing was called); it gets a
     * reference to the thing, not the thing itself?  I'm confused. */
    val oddLength = compose(::isOdd, ::length)

    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength)) // Prints "[a, abc]"

    val predicate: (String) -> Boolean = ::isOdd // refers to isOdd(x: String)

    // Call through works...
    println("Call through works...")
    println("predicate(\"slithy\") produces ${predicate("slithy")}")
    println("oddLength(\"four\") produces ${oddLength("four")}")

    // BobK:  The fuck is the :: doing there in first position?  In the docs this is covered under "Property References"
    println("::x.get starts x: ${::x.get()}") // prints "1"
    println("yeah, but x: $x.  What am I missing?")
    ::x.set(2)
    println("::x.set makes x: $x") // prints "2"
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

    /*
     * BobK:  My mental model here is :: returns a reference which you call through.  Is this what forces the function
     * syntax to be so odd?  My "just use the name" trick doesn't work for properties which can be get and or set by
     * name directly, so now you do need :: to derive the reference rather than return the thing.
     */
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
