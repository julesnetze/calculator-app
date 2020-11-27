import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

class Application {
    private val router = routes(
        "/" bind GET to { Response(OK) },
        "/addition" bind GET to { req: Request ->
            val first = req.query("first").toString()
            val second = req.query("second").toString()
            Response(OK).body(addition(first, second)) },
        "/subtraction" bind GET to { req: Request ->
            val first = req.query("first").toString()
            val second = req.query("second").toString()
            Response(OK).body(subtraction(first, second)) },
        "/multiplication" bind GET to { req: Request ->
            val first = req.query("first").toString()
            val second = req.query("second").toString()
            Response(OK).body(multiplication(first, second)) },
        "/division" bind GET to { req: Request ->
            val first = req.query("first").toString()
            val second = req.query("second").toString()
            Response(OK).body(division(first, second)) }
    )

    private val server = router.asServer(SunHttp(9000))

    fun division(first: String, second: String): String {
        val totalOfDivision = first.toInt() / second.toInt()
        val remainder = first.toInt() % second.toInt()
        return "$totalOfDivision remainder $remainder"
    }

    fun multiplication(first: String, second: String): String {
        val totalOfMultiplication = first.toInt() * second.toInt()
        return totalOfMultiplication.toString()
    }

    fun subtraction(first: String, second: String): String {
        val totalOfSubtraction = first.toInt() - second.toInt()
        return totalOfSubtraction.toString()
    }

    fun addition(first: String, second: String): String {
        val totalOfAddition = first.toInt() + second.toInt()
        return totalOfAddition.toString()
    }

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
