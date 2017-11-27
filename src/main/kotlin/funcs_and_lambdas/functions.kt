package funcs_and_lambdas

/**
 * Doubles the input value of [x].
 * @return 2 * [x].
 */
fun doubleIt(x: Int): Int {
    return 2 * x
}

fun cat(vararg strings: String): String {
    var cat = ""
    strings.forEach { cat = cat + it }
    return cat
}

infix fun Int.plus(x: Int): Int {
    return this + x
}

fun main(args: Array<String>) {
    val x = 2
    println("doubleIt($x) returns ${doubleIt(2)}")

    println("${cat("a", "b")}")
    val catViaSpread = cat(*arrayOf("c", "a", "t"))
    println("$catViaSpread")

    val infixOneplusTwo = 1 plus 2
    val postOneplusTwo = 1.plus(2)
    println("$infixOneplusTwo\n$postOneplusTwo")

}
