plugins {
    id("java-library")
}

abstract class FileDiffTask : DefaultTask() {
    @TaskAction
    fun diff() {
        val file1 = project.file("src/main/resources/static/images/rollercoaster.jpg")
        val file2 = project.file("src/main/resources/static/images/logflume.jpg")

        when (file1.length().compareTo(file2.length())) {
            0 -> println("${file1.name} and ${file2.name} are the same size")
            1 -> println("${file1.name} is bigger than ${file2.name}")
            -1 -> println("${file2.name} is bigger than ${file1.name}")
        }
    }
}

tasks.register<FileDiffTask>("fileDiff") {
}