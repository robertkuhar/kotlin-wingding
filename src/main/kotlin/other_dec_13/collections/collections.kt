package other_dec_13.collections

fun checkNoneGreaterThan(x: Int, list: List<Int>) {
    if (list.none{ it > x}) {
        println("No items greater than $x")
    } else {
        println("There are items greater than $x")
    }
}

fun main(args: Array<String>) {
    val rwList = mutableListOf(1, 2, 3)
    rwList.requireNoNulls() // returns [1, 2, 3]
    if (rwList.none { it > 6 }) {
        println("No items above 6")
    }

    checkNoneGreaterThan(6, rwList)
    checkNoneGreaterThan(2, rwList)
    // checkNoneGreaterThan(2, listOf(1, 2, null, 4))
    /*
     * The .none stuff is interesting.  Jack a null in the mutableListOf and watch a compile error show up!  Why is this
     * a compile time thing?  Its neat but what happens when the list is dynamically passed in or something?
     */
}
