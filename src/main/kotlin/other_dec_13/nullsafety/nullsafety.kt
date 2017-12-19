package other_dec_13.nullsafety

fun main(args: Array<String>) {
    // let, but, meh...
    val listWithNulls: List<String?> = listOf("A", null)
    for (item in listWithNulls) {
        // let turns item into 'it', the "skip the null" here comes from the null-safe navigation thing
        item?.let {
            println("item: $item, it: $it, it is ${it::class.qualifiedName} ${it is String} ${it is String?}")
        }
        // ...but, why?  Up the middle is the same lines of code.
        if (item != null) {
            println("item: $item")
        }
    }

    val bob: String? = "bob"
    if(bob != null) {
        println("${bob::class.qualifiedName}")
    }

    // The Elvis operator ?:
    listWithNulls.forEach {
        val b: String? = it
        val l: Int = if (b != null) b.length else -1
        val elvis_l = b?.length ?: -1
        println("it: $it, l: $l, elvis_l: $elvis_l")
    }
}
