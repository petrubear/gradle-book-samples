package emg.gradle.themepark;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class RideStatusService {

    public static void main(String[] args) {
        if (args.length != 1) {
            log.info("A single ride name must be passed");
            System.exit(1);
        }
        val rideName = args[0];
        val rideStatus = getRideStatus(rideName);
        log.info("Current status of {} is '{}'%n", rideName, rideStatus);
    }

    public static String getRideStatus(String ride) {
        val rideStatuses = readFile(String.format("%s.txt", ride));
        return rideStatuses.get(new Random().nextInt(rideStatuses.size()));
    }

    private static List<String> readFile(String filename) {
        val resourceStream =
            RideStatusService.class.getClassLoader().getResourceAsStream(filename);
        if (resourceStream == null) {
            throw new IllegalArgumentException("Ride not found");
        }
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedInputStream = new BufferedReader(new
            InputStreamReader(resourceStream, StandardCharsets.UTF_8))) {
            while (bufferedInputStream.ready()) {
                result.add(bufferedInputStream.readLine());
            }
        } catch (IOException exception) {
            throw new RuntimeException("Couldn't read file", exception);
        }
        return result;
    }
}
