package other_dec_13.annotations

@Repeatable
@Retention(AnnotationRetention.SOURCE)
annotation class Special(val why: String)

fun makeHello(s: String) = s

const val s = "Hello"

@Special(s) val x = 1

val f = @Special("a") @Special("B") { "hello" }
