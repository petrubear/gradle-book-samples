plugins {
    id("java-library")
}

tasks.register<emg.gradle.themepark.FileDiffTask>("fileDiff") {
    fileA.set(file("src/main/resources/static/images/rollercoaster.jpg"))
    fileB.set(file("src/main/resources/static/images/logflume.jpg"))
}