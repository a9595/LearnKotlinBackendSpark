import spark.Spark.get

/**
 * Created by andrii.kovalchuk on 08/05/2017.
 */

class ServiceRunner {

    fun run() {
        initControllers()
    }

    private fun initControllers() {
        ServiceController()
    }

}