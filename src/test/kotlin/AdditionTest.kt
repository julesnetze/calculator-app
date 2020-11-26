import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdditionTest {

    @Test
    fun `addition of 4 and 3 should return 7`() {
        val app = Application()

        val result = app.addition("4", "3")

        assertEquals("7", result)
    }
}