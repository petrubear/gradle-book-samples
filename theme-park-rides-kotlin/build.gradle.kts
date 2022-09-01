/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.5.1/samples
 */

import org.apache.tools.ant.filters.ReplaceTokens
import kotlin.math.roundToInt

plugins {
    base
    id("org.barfuin.gradle.taskinfo") version "1.4.0"
}

val generateDescriptionsTask = tasks.register<Copy>("generateDescriptions") {
    group = "Theme Park"
    description = "Generate descriptions for the theme park"
    from("descriptions")
    into("$buildDir/descriptions")
    filter(ReplaceTokens::class, "tokens" to mapOf("THEME_PARK_NAME" to "Grelephant's Wonder World"))
    doFirst {
        println("Generating descriptions")
    }
    doLast {
        println("Generated descriptions")
    }
}

val zipDescriptionsTask = tasks.register<Zip>("zipDescriptions") {
    group = "Theme Park"
    description = "Generate zip file from descriptions"
//    from("$buildDir/descriptions/")
    from(generateDescriptionsTask)
    destinationDirectory.set(buildDir)
    archiveFileName.set("descriptions.zip")
    dependsOn(generateDescriptionsTask)
    doFirst {
        println("Generating zip file")
    }
    doLast {
        println("Generated zip file")
    }
    finalizedBy(tasks.named("confirmFinished"))
}

tasks.register<Delete>("deleteDescriptions") {
    group = "Theme Park"
    description = "Delete descriptions for the theme park"
    delete("$buildDir/descriptions")
    doFirst {
        println("Deleting descriptions")
    }
    doLast {
        println("Deleted descriptions")
    }
    mustRunAfter(zipDescriptionsTask)
}

tasks.register("sayHello") {
    group = "Hello World"
    doLast {
        println("Hello World!")
    }
    onlyIf {
        Math.random().roundToInt() % 2 == 0
    }
}

val sayHelloToo by tasks.registering {
    group = "Hello World"
    dependsOn("sayHello")
    doLast {
        println("Hello World Too!")
    }
    enabled = false
}

tasks.named("clean") {
    doLast {
        println("Cleaning up")
    }
}

tasks.register("confirmFinished") {
    doLast {
        println("Finito!")
    }
}