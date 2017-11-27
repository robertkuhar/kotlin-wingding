/**
 * Delegation example from https://kotlinlang.org/docs/reference/delegation.html
 */
interface Base {
    fun print()
}

interface Foo {
    fun bar()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println("BaseImpl.print says $x")
    }
}

class FooImpl() : Foo {
    override fun bar() {
        println("FooImpl.bar() says \"bar\"!!!")
    }
}

class Derived(b: Base, f: Foo) : Base by b, Foo by f

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    val f = FooImpl()
    val d = Derived(b,f)
    d.print();
    d.bar();
}
