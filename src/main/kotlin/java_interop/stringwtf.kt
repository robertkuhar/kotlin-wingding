package java_interop

fun main(args: Array<String>) {
    val s: String = Stuff.S_NOT_NULL
    println("s, s::class.simpleName: ${s::class.simpleName}")
    println("s, s::class.qualifiedName: ${s::class.qualifiedName}")

    val s1: String? = Stuff.S_NULL
    // no can do, compiler says NO!
    // println("s1, s1::class.simpleName: ${s1::class.simpleName}")
    // println("s1, s1::class.qualifiedName: ${s1::class.qualifiedName}")

    val s2 = Stuff.makeString("robert")
    println("s2, s2::class.simpleName: ${s2::class.simpleName}")
    println("s2, s2::class.qualifiedName: ${s2::class.qualifiedName}")

    val s3 = Stuff.makeString(null)
    println("s3, s3::class.simpleName: ${s3::class.simpleName}")
    println("s3, s3::class.qualifiedName: ${s3::class.qualifiedName}")
}