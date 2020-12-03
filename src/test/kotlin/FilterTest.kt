import org.http4k.core.*
import org.http4k.core.Method.GET
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_CLASS)
class FilterTest {

    lateinit var handler: HttpHandler
    private val uri = "http://localhost:9000"

    @BeforeAll
    fun setUp() {
        handler = queryFilter.then { Response(OK) }
    }

    @Test
    fun `should return OK if first and second query parameter are valid`() {
        val request = Request(GET, uri)
            .query("first", "1")
            .query("second", "1")

        val response = handler(request)

        assertEquals(OK,response.status)
    }

    @Test
    fun `should return BAD REQUEST if first and second query parameter are invalid`() {
        val request = Request(GET, uri)
            .query("first", "foo")
            .query("second", "bar")

        val response = handler(request)

        assertEquals(BAD_REQUEST,response.status)
    }

    @Test
    fun `should return BAD REQUEST if first and second parameter are not present`() {
        val request = Request(GET, uri)

        val response = handler(request)

        assertEquals(BAD_REQUEST,response.status)
    }
}