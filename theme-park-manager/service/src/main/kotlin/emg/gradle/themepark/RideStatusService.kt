package emg.gradle.themepark

import org.apache.commons.lang3.StringUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*

class RideStatusService {
    companion object {
        @JvmStatic
        fun getRideStatus(ride: String): String {
            val random = Random()
            val trimmedRideName = StringUtils.trim(ride)
            val rideStatuses = readFile(String.format("%s.txt", trimmedRideName))
            return rideStatuses[random.nextInt(rideStatuses.size)]
        }

        private fun readFile(filename: String): List<String> {
            val resourceStream = RideStatusService::class.java.classLoader.getResourceAsStream(filename)
                ?: throw IllegalArgumentException("Ride not found")
            val result: MutableList<String> = ArrayList()
            try {
                BufferedReader(InputStreamReader(resourceStream, StandardCharsets.UTF_8)).use { bufferedInputStream ->
                    while (bufferedInputStream.ready()) {
                        result.add(bufferedInputStream.readLine())
                    }
                }
            } catch (exception: IOException) {
                throw RuntimeException("Couldn't read file", exception)
            }
            return result
        }
    }
}
