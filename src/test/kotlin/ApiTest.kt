import org.http4k.client.ApacheClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiTest {

    private lateinit var app: Application
    lateinit var client: HttpHandler

    @BeforeAll
    fun setUp() {
        app = Application()
        client = ApacheClient()
        app.start()
    }

    @Test
    fun `server should be up`() {
        val request = Request(GET, "http://localhost:9000")

        val response: Response = client(request)
        assertEquals(OK, response.status)
    }

    @Test
    fun `addition of 2 and 3 should return 5`() {
        val request = Request(GET, "http://localhost:9000/addition")
            .query("first", "2")
            .query("second", "3")

        val response: Response = client(request)
        assertEquals("5", response.body.toString())
    }

    @Test
    fun `subtraction of 3 minus 2 should return 1`() {
        val request = Request(GET, "http://localhost:9000/subtraction")
            .query("first", "3")
            .query("second", "2")

        val response = client(request)
        assertEquals("1", response.body.toString())
    }

    @Test
    fun `multiplication of 3 times 2 should return 6`() {
        val request = Request(GET, "http://localhost:9000/multiplication")
            .query("first", "3")
            .query("second", "2")

        val response = client(request)
        assertEquals("6", response.body.toString())
    }

    @Test
    fun `division of 5 by 3 should return 1 remainder 2`() {
        val request = Request(GET, "http://localhost:9000/division")
            .query("first", "5")
            .query("second", "3")

        val response = client(request)
        assertEquals("1 remainder 2", response.body.toString())
    }

    @Disabled
    @Test
    fun `addition of null and 1 should return an error`() {
        val request = Request(GET, "http://localhost:9000/addition")
            .query("first", null)
            .query("second", "3")

        val response = client(request)
        assertEquals("error", response.body.toString())
    }

    @AfterAll
    fun tearDown() {
        app.stop()
    }
}