import org.http4k.core.*
import org.http4k.core.Method.GET
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_CLASS)
class FilterTest {

    lateinit var app: Application
    lateinit var handler: HttpHandler
    private val uri = "http://localhost:9000"

    @BeforeAll
    fun setUp() {
        app = Application()
        handler = app.queryFilter.then { Response(OK) }
    }

    @Test
    fun `should return OK if first and second query parameter are valid`() {
        val response: Response = handler(Request(GET, uri)
            .query("first", "1")
            .query("second", "1"))

        assertEquals(OK,response.status)
    }

    @Test
    fun `should return BAD REQUEST if first and second query parameter are invalid`() {
        val response: Response = handler(Request(GET, uri)
            .query("first", "foo")
            .query("second", "bar"))

        assertEquals(BAD_REQUEST,response.status)
    }

    @Test
    fun `should return BAD REQUEST if first and second parameter are not present`() {
        val response: Response = handler(Request(GET, uri))

        assertEquals(BAD_REQUEST,response.status)
    }

    @AfterAll
    fun tearDown() {
        app.stop()
    }
}