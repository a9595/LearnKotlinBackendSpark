package managers

import de.bytefish.fcmjava.client.FcmClient
import de.bytefish.fcmjava.client.settings.PropertiesBasedSettings
import de.bytefish.fcmjava.model.enums.PriorityEnum
import de.bytefish.fcmjava.model.options.FcmMessageOptions
import de.bytefish.fcmjava.requests.data.DataUnicastMessage
import java.nio.charset.Charset
import java.nio.file.FileSystems
import java.time.Duration

class PushManager {

    fun sendPush() {
        val path = FileSystems.getDefault().getPath(".fcmjava/fcmjava.properties");
        val client = FcmClient(PropertiesBasedSettings.createFromFile(
                path,
                Charset.defaultCharset()))

        val options = FcmMessageOptions.builder()
                .setTimeToLive(Duration.ofDays(21))
                .setPriorityEnum(PriorityEnum.High)
                .build()
        val data = OrderPush("sdfdsfsdf", "userId", "TRF3", "sdflsdfkjsdlfj")

        val to = "c_l8mzJ-DcQ:APA91bGRmOaPJQC1xS85DAGYG63AiAQA2R1VxXQBJFzxd9E_29seXXTaIpCEGPFqixroK16mY4zmB7-MQFW2Sl0HV5i64K4T-P3NjAgozru2LqAsIXjzoGpaFcvjyoHQExGeFCedl5OH"

        client.send(DataUnicastMessage(options, to, data))
        println("Notification sent")
    }

}