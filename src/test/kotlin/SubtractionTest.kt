import domain.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubtractionTest {

    @Test
    fun `1 minus 1 should return 0`() {
        val calculator = Calculator()

        val result = calculator.subtraction("1", "1")

        assertEquals("0", result)
    }
}