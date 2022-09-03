plugins {
    id("emg.gradle.themepark-conventions")
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("org.barfuin.gradle.taskinfo") version "1.4.0"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":service"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}
