import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.SunHttp
import org.http4k.server.asServer

class Application {
    private val router = { _: Request ->
        Response(OK)
    }

    private val server = router.asServer(SunHttp(9000))

    fun start() {
        server.start()
    }

    fun stop() {
        server.stop()
    }
}

val app = Application()
fun main() {
    app.start()
}

fun stop() {
    app.stop()
}
