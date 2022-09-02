plugins {
    java
    id("org.springframework.boot") version "2.5.3"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
dependencies {
    implementation(project(":ui"))

    implementation(project(":service"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}