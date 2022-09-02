package emg.gradle.themepark.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ThemeParkApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(ThemeParkApplication::class.java, *args)
}