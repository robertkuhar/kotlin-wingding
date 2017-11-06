import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Delegated Properties example:  https://kotlinlang.org/docs/reference/delegated-properties.html
 */
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class Example {
    var p: String by Delegate()
}

class User {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("${prop.name} $old -> $new")
    }

    var nickname: String by Delegates.vetoable("<no nickname>") { prop, old, new ->
        if (new == "Dread Pirate Robert") {
            true
        } else {
            println("from vetoable:  VETOING \"$new\".  Retaining \"$old\"")
            false
        }
    }
}

class UserPropsAsMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main(args: Array<String>) {
    val example = Example()
    example.p = "Robert"
    println(example.p)

    val lazyValue: String by lazy {
        // Bobk:  This is synchronized by lazy, somehow
        println("computed \"Hello\"!")
        "Hello"
    }
    println("first call\t$lazyValue")
    println("second call\t$lazyValue")

    val user = User()
    user.name = "Robert Kuhar"
    user.name = "Bob Kuhar"

    var candidateNickname = "Dread Pirate Robert"
    user.nickname = candidateNickname
    println("try \"$candidateNickname\" results in \"${user.nickname}\"")
    candidateNickname = "Batman"
    user.nickname = candidateNickname
    println("try \"$candidateNickname\" results in \"${user.nickname}\"")

    val userAsMap = UserPropsAsMap(mapOf(
            "name" to "John Doe",
            "age" to 25,
            "nickname" to "Doe-boy"
    ))
    // BobK.  Interesting.  nickname is not an error, but doesn't work either
    println("${userAsMap.name} is ${userAsMap.age}.  People know him as $userAsMap.nickname")
}