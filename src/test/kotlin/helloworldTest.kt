import org.junit.Assert.assertEquals
import org.junit.Test

// BobK:  Do I have to be in a class?
class helloworldTest {
    @Test
    fun testHelloWorld() {
        assertEquals("Hello, world!", sayHelloWorld())
    }
}