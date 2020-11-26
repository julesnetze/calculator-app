import org.http4k.client.ApacheClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class ApiTest {

    val app = Application()
    val client = ApacheClient()

    @BeforeEach
    fun setUp() {
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
        val request = Request(GET, "http://localhost:9000/addition?first=2&second=3")

        val response: Response = client(request)
        assertEquals("5", response.body.toString())
    }

    @AfterEach
    fun tearDown() {
        app.stop()
    }
}