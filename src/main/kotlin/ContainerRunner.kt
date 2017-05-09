import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseCredentials
import managers.PushManager
import java.io.FileInputStream

/**
 * Created by andrii.kovalchuk on 08/05/2017.
 */

fun main(args: Array<String>) {
    initFirebase()
    PushManager().sendPush()

    ServiceRunner().run()
}

private fun initFirebase() {
    val serviceAccount = FileInputStream("PJA Buffet-f41d18e3b901.json")

    val options = FirebaseOptions.Builder()
            .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
            .setDatabaseUrl("https://pja-buffet.firebaseio.com")
            .build()

    FirebaseApp.initializeApp(options)
}