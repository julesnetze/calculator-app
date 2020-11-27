import domain.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubtractionTest {

    @Test
    fun `3 minus 2 should return 1`() {
        val calculator = Calculator()

        val result = calculator.subtraction("3", "2")

        assertEquals("1", result)
    }
}