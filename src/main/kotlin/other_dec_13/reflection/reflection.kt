package other_dec_13.reflection

import kotlin.reflect.jvm.jvmName

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isOdd(x: Int) = x % 2 != 0

var x = 1

class A(val p: Int)

class MyClass {

}

fun main(args: Array<String>) {

    val c = MyClass::class
    println("simpleName: ${c.simpleName}")
    println("qualifiedName: ${c.qualifiedName}")
    println("jvmName: ${c.jvmName}")

    val myClass = MyClass()
    println("myClass::class.simpleName: ${myClass::class.simpleName}")
    println("myClass::class.qualifiedName: ${myClass::class.qualifiedName}")
    println("myClass::class.jvmName: ${myClass::class.jvmName}")

    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    fun length(s: String) = s.length

    /*
     * BobK:  The :: syntax feels strange to me.  Why couldn't I have just used the function;s name here (Ex: isOdd)?
     * I'm obviously not calling it as that would be like isOdd(1).  The :: is feeling superfluous to me.
     *
     * Perhaps Kotlin's :: is like C's & unary operator (I think that is what that thing was called); it gets a
     * reference to the thing, not the thing itself.  I wonder if you can "call through" like apply(::isOdd, 3) or
     * something?
     */
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength)) // Prints "[a, abc]"

    println("::x.get starts x: ${::x.get()}") // prints "1"
    ::x.set(2)
    println("::x.set makes x: $x") // prints "2"
    x = 3
    println("yeah, but x: $x")

    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length)) // prints [1,2,3]

    /*
     * BobK:  My mental model here is :: returns a reference which you call through.  Is this what forces the function
     * syntax to be so odd?  My "just use the name" trick doesn't work for properties which can be get and or set by
     * name directly, so now you do need :: to derive the reference rather than return the thing.
     */
    val prop = A::p
    println("the value of A(1) is: ${prop.get(A(1))}") // prints "the value of A(1) is: 1"
    println("the value of A(2) is: ${prop.get(A(2))}") // prints "the value of A(2) is: 2"

    val numberRegex = "\\d+".toRegex()
    println("numberRegex.matches(\"29\") -> ${numberRegex.matches("29")}") // prints "true"
    val isNumber = numberRegex::matches
    println("isNumber(29) -> ${isNumber("29")}") // prints "true"
    println("isNumber(\"robert\") -> ${isNumber("robert")}") // prints "false"

    val moreStrings = listOf("abc", "124", "a70")
    println(moreStrings.filter(numberRegex::matches)) // prints "[124]"
}
