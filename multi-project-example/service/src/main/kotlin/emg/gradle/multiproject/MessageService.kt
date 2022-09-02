package emg.gradle.multiproject

import java.util.*

class MessageService {
    fun generateMessage(): String {
        val messages = listOf("Hello", "World", "Gradle")
        return messages[Random().nextInt(messages.size)]
    }
}