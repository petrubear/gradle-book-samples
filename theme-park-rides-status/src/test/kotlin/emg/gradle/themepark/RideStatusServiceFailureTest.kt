package emg.gradle.themepark

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class RideStatusServiceFailureTest {
    @Test
    fun unknownRideCausesFailure() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            RideStatusService.getRideStatus(
                "dodgems"
            )
        }
    }

    @Test
    fun notAGoodTest() {
        fail("Expected to fail")
    }
}