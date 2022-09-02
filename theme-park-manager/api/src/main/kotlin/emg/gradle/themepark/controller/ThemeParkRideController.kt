package emg.gradle.themepark.controller

import emg.gradle.themepark.RideStatusService
import emg.gradle.themepark.model.ThemeParkRide
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ThemeParkRideController {
    @GetMapping(path = ["/rides"])
    fun getRides(): Iterator<ThemeParkRide> {
        return listOf(
            ThemeParkRide(
                "Rollercoaster",
                "Train ride that speeds you along.",
                RideStatusService.getRideStatus("rollercoaster"),
                "images/rollercoaster.jpg"
            ),
            ThemeParkRide(
                "Log flume",
                "Boat ride with plenty of splashes.",
                RideStatusService.getRideStatus("logflume"),
                "images/logflume.jpg"
            ),
            ThemeParkRide(
                "Teacups",
                "Spinning ride in a giant tea-cup.",
                RideStatusService.getRideStatus("teacups"),
                "images/teacups.jpg"
            )
        ).iterator()
    }
}