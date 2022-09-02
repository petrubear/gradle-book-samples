package emg.gradle.themepark

class RideStatusUtils {
    fun start(): Long {
        return System.currentTimeMillis()
    }

    fun finish(start: Long): Long {
        return System.currentTimeMillis() - start
    }
}