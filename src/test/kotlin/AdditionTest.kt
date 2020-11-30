import domain.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdditionTest {

    @Test
    fun `addition of 1 and 1 should return 2`() {
        val app = Calculator()

        val result = app.addition("1", "1")

        assertEquals("2", result)
    }
}