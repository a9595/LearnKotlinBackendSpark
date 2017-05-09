package controllers

import spark.Spark.get

/**
 * Created by andrii.kovalchuk on 08/05/2017.
 */
class ServiceController {

    init {
        get("/hello", { request, response ->
            "Hello world2"
        })
    }
}