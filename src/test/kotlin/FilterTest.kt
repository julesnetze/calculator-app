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

    @BeforeAll
    fun setUp() {
        app = Application()
        handler = app.queryFilter.then { Response(OK) }
    }

    @Test
    fun `should return OK if first and second query parameter are valid`() {
        val response: Response = handler(Request(GET, "http://localhost:9000")
            .query("first", "2")
            .query("second", "3"))

        assertEquals(OK,response.status)
    }

    @Test
    fun `should return BAD Request if first and second query parameter are invalid`() {
        val response: Response = handler(Request(GET, "http://localhost:9000")
            .query("first", "foo")
            .query("second", "bar"))

        assertEquals(BAD_REQUEST,response.status)
    }

    @Test
    fun `should return Bad Request if first and second parameter are not present`() {
        val response: Response = handler(Request(GET, "http://localhost:9000"))

        assertEquals(BAD_REQUEST,response.status)
    }

    @AfterEach
    fun tearDown() {
        app.stop()
    }
}