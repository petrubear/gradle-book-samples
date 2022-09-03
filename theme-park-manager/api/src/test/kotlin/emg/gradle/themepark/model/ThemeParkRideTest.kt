package emg.gradle.themepark.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThemeParkRideTest {
    @Test
    fun setsFieldsCorrectly() {
        val themeParkRide = ThemeParkRide(
            "Ride name", "description",
            "status", "some/path.jpg"
        )
        assertEquals("Ride name", themeParkRide.name)
        assertEquals("description", themeParkRide.description)
        assertEquals("status", themeParkRide.status)
        assertEquals("some/path.jpg", themeParkRide.imagePath)
    }
}