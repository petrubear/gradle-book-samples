plugins {
    id("java-library")
    //id "java-library"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf("Main-Class" to "com.gradlehero.themepark.RideStatusService"))
    }
}

tasks.withType(Test::class.java).configureEach {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runJar") {
    classpath += tasks.named<Jar>("jar").map { it.outputs.files }.get()
    classpath += configurations.runtimeClasspath
    mainClass.set("com.gradlehero.themepark.RideStatusService")
    args = listOf("teacups")
}
