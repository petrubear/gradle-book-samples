package emg.gradle.themepark.api.controller

import emg.gradle.themepark.api.model.ThemeParkRide
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ThemeParkRideController {
    @GetMapping("/rides")
    fun getRides(): Iterator<ThemeParkRide> {
        return listOf(
            ThemeParkRide("Rollercoaster", "Train ride that speeds you along."),
            ThemeParkRide("Log Flume", "Boat ride with plenty of splashes."),
            ThemeParkRide("Teacups", "Spinning ride in a giant teacup.")
        ).iterator()
    }
}