import spark.Spark

/**
 * Created by andrii.kovalchuk on 08/05/2017.
 */
class ServiceController {

    init {
        Spark.get("/hello", { request, response ->
            "Hello world2"
        })
    }
}