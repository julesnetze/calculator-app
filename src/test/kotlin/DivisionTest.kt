import domain.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivisionTest {

    @Test
    fun `5 divided by 3 should return 1 remainder 2`() {
        val calculator = Calculator()

        val result = calculator.division("5", "3")

        assertEquals("1 remainder 2", result)
    }
}