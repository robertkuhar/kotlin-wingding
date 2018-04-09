import org.junit.Assert.assertEquals
import org.junit.Test

// This has to be a class, yuk.  Methinks JUnit is to blame.
class helloworldTest {
    @Test
    fun testHelloWorld() {
        assertEquals("Hello, World!", sayHelloWorld())
    }
}