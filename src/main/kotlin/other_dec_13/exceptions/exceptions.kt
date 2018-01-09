package other_dec_13.exceptions

class MyException : Throwable {
    constructor() : super() {}
    constructor(message: String?) : super(message) {}
    constructor(cause: Throwable?) : super(cause) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
}

fun main(args: Array<String>) {
    val result = try {
        if(args.size % 2 != 0) {
            throw MyException("the len of args is odd")
        }
        "even"
    } catch (e: MyException) {
        "odd"
    } finally {
        "neutral"
    }
    println("the len of args is an $result number")
}