import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MultiplicationTest {

    @Test
    fun `3 times 2 should return 6`() {
        val app = Application()

        val result = app.multiplication("3", "2")

        assertEquals("6", result)
    }
}