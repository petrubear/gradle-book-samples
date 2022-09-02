plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("org.barfuin.gradle.taskinfo") version "1.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":service"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10")
    implementation("org.springframework.boot:spring-boot-starter-web")
}