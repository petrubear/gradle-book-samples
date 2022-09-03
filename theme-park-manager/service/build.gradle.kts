plugins {
    id("emg.gradle.themepark-conventions")
    id("java-library")
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf("Main-Class" to "com.gradlehero.themepark.RideStatusService"))
    }
}

tasks.register<JavaExec>("runJar") {
    classpath += tasks.named<Jar>("jar").map { it.outputs.files }.get()
    classpath += configurations.runtimeClasspath
    mainClass.set("com.gradlehero.themepark.RideStatusService")
    args = listOf("teacups")
}
