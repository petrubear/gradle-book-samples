package emg.gradle.themepark;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RideStatusServiceTest {

    @ParameterizedTest(name = "{index} gets {0} ride status")
    @ValueSource(strings = {"rollercoaster", "logflume", "teacups"})
    void getsRideStatus(String ride) {
        RideStatusService rideStatusService = new RideStatusService();
        String rideStatus = rideStatusService.getRideStatus(ride);
        assertNotNull(rideStatus);
    }
}
