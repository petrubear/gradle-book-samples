plugins {
    id("java")
}

group = "emg.gradle.dependencies"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    implementation(group = "commons-beanutils", name = "commons-beanutils", version = "1.9.4") {
        exclude(group = "commons-collections", module = "commons-collections")
    }
}