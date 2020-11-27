import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubtractionTest {

    @Test
    internal fun `3 minus 2 should return 1`() {
        val app = Application()

        val result = app.subtraction("3", "2")

        assertEquals("1", result)
    }
}