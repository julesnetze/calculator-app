import org.http4k.client.ApacheClient
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApiTest {

    @Test
    fun `server should be up`() {
        val client = ApacheClient()
        val server = Application()
        server.main()

        val request = Request(GET, "http://localhost:9000")

        val response: Response = client(request)

        assertEquals(Status.OK, response.status)
    }
}