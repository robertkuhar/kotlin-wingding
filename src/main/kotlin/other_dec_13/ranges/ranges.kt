package other_dec_13.ranges

fun main(args: Array<String>) {
    val twoThreeFour = 2..4
    for(i in 1..5) {
        /*
         * This is interesting.  There isn't a function called 'in', the function is contains...it becomes 'in'
         * through some other mechanism.  That's strange to me...
         */
        if(i in twoThreeFour) {
            println("$i is in $twoThreeFour")
        }
        if(i !in twoThreeFour) {
            println("$i IS NOT in $twoThreeFour")
        }
    }
    for (i in 1..4) print(i) // prints "1234"
    println("")
    for (i in 4..1) print(i) // prints nothing
    println("")
    for (i in 4 downTo 1) print(i) // prints "4321"
    println("")

    /*
     * Hmmm, why not allow 4..1 and infer the negative step?  This compiles, but IllegalArgumentException if you run!?!
     */
    // val tenToZeroStepTwo = 10..0 step -2
    // for(i in tenToZeroStepTwo) print("wow, $i.  ")

    val one = 1
    val ten = 10
    val z = one..ten step 1
    for(i in z) print("pow, $i.  ")

    val oneUntilTen = 1 until 10
    for (i in oneUntilTen) { // i in [1, 10), 10 is excluded println(i)
        if(i in twoThreeFour) {
            // Note the toString of oneUntilTen...its actually 1..9
            println("hello $i is in $oneUntilTen")
        }
    }
    val oneRangeToFour = 1.rangeTo(4)
    for(i in oneRangeToFour) println("$i in oneRangeToFour: $oneRangeToFour")
    println("")
    val fourDownToOne = oneRangeToFour.reversed()
    for(i in fourDownToOne) println("$i in fourDownToOne: $fourDownToOne")
    println("")
}
