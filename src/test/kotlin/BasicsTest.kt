import org.junit.Assert.assertEquals
import org.junit.Test

class BasicsTest {
    @Test
    fun basicTypes() {
        val immaInt: Int = 1_000_000
        // val immaLong: Long = immaInt; // compile error
        val immaLong: Long = immaInt.toLong();
    }

}