package other_dec_13.typechecks

fun isOrIsNotString(obj: Any) {
    if (obj is String) {
        // The is check cast this guy to String so I don't have to do anything further
        println("obj is a String of length ${obj.length}")
    }
    if (obj !is String) {
        println("obj is NOT a String")
    }
}

fun smartCasts(x: Any) {
    if (x !is String) return
    println("smartCasts: ${x.length}") // x is automatically

    // x is automatically cast to String on the right-hand side of `||`
    if (x !is String || x.length == 0) return

    // x is automatically cast to String on the right-hand side of `&&`
    if (x is String && x.length > 0) {
        println("smartCasts: Again, the length is ${x.length}")
    }
}

fun smartCastsInWhen(x: Any) {
    when (x) {
        is Int -> println("smartCastsInWhen: Add one to the Int ${x + 1}")
        is String -> println("smartCastsInWhen: Add one to the String's length ${x.length + 1}")
        is IntArray -> println("smartCastsInWhen: Sum the array ${x.sum()}")
    }
}

fun main(args: Array<String>) {
    isOrIsNotString("Robert")
    isOrIsNotString(1)

    smartCasts("Robert")
    smartCasts(1)
    smartCasts("")

    smartCastsInWhen(5)
    smartCastsInWhen("Robert")
    smartCastsInWhen(intArrayOf(1, 2, 3))
}