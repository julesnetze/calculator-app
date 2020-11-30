import domain.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MultiplicationTest {

    @Test
    fun `1 times 2 should return 2`() {
        val app = Calculator()

        val result = app.multiplication("1", "2")

        assertEquals("2", result)
    }
}