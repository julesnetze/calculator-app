import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivisionTest {

    @Test
    fun `5 divided by 3 should return 1 remainder 2`() {
        val app = Application()

        val result = app.division("5", "3")

        assertEquals("1 remainder 2", result)
    }
}