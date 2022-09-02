/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.5.1/samples
 */

plugins {
    java
    application
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("org.barfuin.gradle.taskinfo") version "1.4.0"
    id("org.unbroken-dome.test-sets") version "4.0.0"
}

application {
    mainClass.set("emg.gradle.themepark.RideStatusService")
}

sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        vendor.set(JvmVendorSpec.AMAZON)
    }
}

val jar = tasks.named<Jar>("jar") {
    doFirst {
        println("Setting Manifest")
    }

    manifest {
        attributes["Main-Class"] = "emg.gradle.themepark.RideStatusService"
    }

    // con esto hago un fat jar!
    // from(configurations.runtimeClasspath.get().map {
    // if (it.isDirectory) it else zipTree(it)
    // })
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    archiveFileName.set("ride-status-service.jar")
}

tasks.named<Delete>("clean") {
    delete("bin")
}

tasks.named<ProcessResources>("processResources") {
    include("**/*.txt")
}

tasks.named<JavaCompile>("compileJava") {
    options.isVerbose = true
}

tasks.withType<JavaCompile>().forEach {
    it.options.isVerbose = true
}

tasks.register<JavaExec>("runJar") {
//    classpath = tasks.named<Jar>("jar").map {
    classpath += jar.map { it.outputs.files }.get()
    classpath += configurations.runtimeClasspath.get()
    mainClass.set("emg.gradle.themepark.RideStatusService")
    args = listOf("rollercoaster")
}

tasks.withType<Test> {
    useJUnitPlatform()
    // useTestNG()
    exclude("**/*RideStatusServiceFailureTest*")
}

testSets {
    createTestSet("integrationTest") {
    }
}

val lombokVersion by extra("1.18.24")
val slf4jVersion by extra("2.0.0")
val junitVersion by extra("5.9.0")
val commonsLangVersion by extra("3.12.0")

dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")

    implementation("org.apache.commons:commons-lang3:$commonsLangVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

repositories {
    mavenCentral()
}
