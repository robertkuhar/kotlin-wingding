package funcs_and_lambdas

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true
    }
    return false
}

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    println("hasZeros($ints) returns ${hasZeros(ints)}")

    ints.add(0)
    println("hasZeros($ints) returns ${hasZeros(ints)}")
}
