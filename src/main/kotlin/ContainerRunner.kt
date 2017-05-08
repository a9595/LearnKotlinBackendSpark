import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseCredentials
import de.bytefish.fcmjava.client.FcmClient
import de.bytefish.fcmjava.client.settings.PropertiesBasedSettings
import de.bytefish.fcmjava.model.options.FcmMessageOptions
import de.bytefish.fcmjava.requests.data.DataUnicastMessage
import java.io.FileInputStream
import java.nio.file.Path
import java.time.Duration

/**
 * Created by andrii.kovalchuk on 08/05/2017.
 */

fun main(args: Array<String>) {
    ServiceRunner().run()

    initFirebase()
    initFCM()
}

fun initFCM() {
    val client = FcmClient(PropertiesBasedSettings.createFromDefault())

    val options = FcmMessageOptions.builder()
            .setTimeToLive(Duration.ofHours(1))
            .build()

    client.send(DataUnicastMessage(options, "", ))
}

private fun initFirebase() {
    val serviceAccount = FileInputStream("PJA Buffet-f41d18e3b901.json")

    val options = FirebaseOptions.Builder()
            .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
            .setDatabaseUrl("https://pja-buffet.firebaseio.com")
            .build()

    FirebaseApp.initializeApp(options)
}