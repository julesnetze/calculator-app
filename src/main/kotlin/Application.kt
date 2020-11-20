import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.SunHttp
import org.http4k.server.asServer

class Application {
    private val router = { _: Request ->
        Response(OK)
    }
    val server = router.asServer(SunHttp(9000))
}

val app = Application().server
fun main() {
    app.start()
}

fun stop() {
    app.stop()
}
