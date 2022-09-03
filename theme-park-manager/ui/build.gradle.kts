plugins {
    id("java-library")
}

open class FileDiffTask @Inject constructor(objects: ObjectFactory) : DefaultTask() {
    @InputFile
    val fileA: RegularFileProperty = objects.fileProperty()

    @InputFile
    val fileB: RegularFileProperty = objects.fileProperty()

    @TaskAction
    fun diff() {
        val f1 = fileA.orNull?.asFile
        val f2 = fileB.orNull?.asFile

        f1?.let { file1 ->
            f2?.let { file2 ->
                when (file1.length().compareTo(file2.length())) {
                    0 -> println("${file1.name} and ${file2.name} are the same size")
                    1 -> println("${file1.name} is bigger than ${file2.name}")
                    -1 -> println("${file2.name} is bigger than ${file1.name}")
                }
            }
        }

    }
}

tasks.register<FileDiffTask>("fileDiff") {
    fileA.set(file("src/main/resources/static/images/rollercoaster.jpg"))
    fileB.set(file("src/main/resources/static/images/logflume.jpg"))
}