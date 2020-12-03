import org.http4k.client.ApacheClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiTest {

    private lateinit var app: Application
    lateinit var client: HttpHandler
    private val baseUri = "http://localhost:9000"

    @BeforeAll
    fun setUp() {
        app = Application()
        client = ApacheClient()
        app.start()
    }

    @Test
    fun `server should be up`() {
        val request = Request(GET, baseUri)

        val response = client(request)

        assertEquals(OK, response.status)
    }

    @Test
    fun `addition of 1 and 1 should return 2`() {
        val request = Request(GET, "$baseUri/addition")
            .query("first", "1")
            .query("second", "1")

        val response = client(request)

        assertEquals("2", response.body.toString())
    }

    @Test
    fun `subtraction of 1 minus 1 should return 0`() {
        val request = Request(GET, "$baseUri/subtraction")
            .query("first", "1")
            .query("second", "1")

        val response = client(request)

        assertEquals("0", response.body.toString())
    }

    @Test
    fun `multiplication of 1 times 2 should return 2`() {
        val request = Request(GET, "$baseUri/multiplication")
            .query("first", "1")
            .query("second", "2")

        val response = client(request)

        assertEquals("2", response.body.toString())
    }

    @Test
    fun `division of 5 by 3 should return 1 remainder 2`() {
        val request = Request(GET, "$baseUri/division")
            .query("first", "5")
            .query("second", "3")

        val response = client(request)

        assertEquals("1 remainder 2", response.body.toString())
    }

    @Test
    fun `addition of null and 1 should return BAD REQUEST`() {
        val request = Request(GET, "$baseUri/addition")
            .query("first", null)
            .query("second", "3")

        val response = client(request)

        assertEquals(BAD_REQUEST, response.status)
    }

    @Test
    fun `addition with no query parameters should return BAD REQUEST`() {
        val request = Request(GET, "$baseUri/addition")

        val response = client(request)

        assertEquals(BAD_REQUEST, response.status)
    }

    @AfterAll
    fun tearDown() {
        app.stop()
    }
}