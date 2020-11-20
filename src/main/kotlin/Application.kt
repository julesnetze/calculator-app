import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.Status.Companion.OK
import org.http4k.server.SunHttp
import org.http4k.server.asServer

class Application {

    private val app = { _: Request ->
        Response(OK)
    }

    fun main() {
        app.asServer(SunHttp(9000)).start()
    }

}