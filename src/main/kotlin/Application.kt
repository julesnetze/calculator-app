import domain.Calculator
import org.http4k.core.*
import org.http4k.core.Method.GET
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

class Application {
    private val calculator = Calculator()

    val queryFilter = Filter {
        next: HttpHandler -> {
            request: Request ->
                val first = request.query("first")?.toIntOrNull()
                val second = request.query("second")?.toIntOrNull()
                if (first == null || second == null) {
                    Response(BAD_REQUEST)
                } else {
                    next(request)
                }
            }
    }

    private val router = routes(
        "/" bind GET to { Response(OK) },
        queryFilter.then(routes(
        "/addition" bind GET to { req: Request ->
            val first = req.query("first")
            val second = req.query("second")
            Response(OK).body(calculator.addition(first, second)) },
        "/subtraction" bind GET to { req: Request ->
            val first = req.query("first")
            val second = req.query("second")
            Response(OK).body(calculator.subtraction(first, second)) },
        "/multiplication" bind GET to { req: Request ->
            val first = req.query("first")
            val second = req.query("second")
            Response(OK).body(calculator.multiplication(first, second)) },
        "/division" bind GET to { req: Request ->
            val first = req.query("first")
            val second = req.query("second")
            Response(OK).body(calculator.division(first, second)) }
    )))

    private val server = router.asServer(SunHttp(9000))

    fun start() {
        server.start()
    }

    fun stop() {
        server.stop()
    }
}

fun main() {
    Application().start()
}
