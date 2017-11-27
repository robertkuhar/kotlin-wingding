package other_dec_13.destructuring

fun makeResults(x: Int): Results {
    return if (x % 2 == 0) { Results(x, "Even") } else { Results(x,"Odd") }
}

fun destructuring() {
    println("makeResults(11) is ${makeResults(11)}")
    val (result, status) = makeResults(12)
    // BobK:  Lame-o.  The destructuring is positional!?! val (status,result) != val (result,status)
    // val (status,result) = makeResults(12)
    println("result $result status $status")

    val person = Person("Robert", 52, mutableSetOf())
    println("person ${person}")
    person.aliases.add("Dread Pirate Robert")
    println("person ${person}")
    val (name,age) = person
    println("name: $name, age: $age")
    /*
     * BobK:  I am no longer a fan.  The positional stuff is just dumb.  aliases comes out "Robert" below.  The
     * compiler could have "done the right thing" here, no?  It had all the information to make the access somehow
     * other than positional.
     *
     * I don't think I am alone in my opinion:
     * [Kotlin destructuring considered harmful](https://medium.com/@dmstocking/kotlin-destructuring-considered-harmful-2a5fa2397cac)
     */
    val (aliases) = person
    println("aliases: $aliases")

    val digitInEspanol = mapOf<Int,String>(
            0 to "Cero",
            1 to "Uno",
            2 to "Dos",
            3 to "Tres",
            4 to "Quatro",
            5 to "Cinco",
            6 to "Seis",
            7 to "Siete",
            8 to "Ocho",
            9 to "Nueve")
    for((_,v) in digitInEspanol) {
        // BobK: I'm a little impressed it maintained the insertion order.  Luck?
        println("v is $v")
    }
}

fun main(args: Array<String>) {
    destructuring()
}
