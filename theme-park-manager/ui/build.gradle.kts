plugins {
    id("java-library")
}

// the following task generates downloadable for lesson "Practical: creating a multi-project build" so can be ignored
/*
tasks.register("downloadable", Copy) {
    from parent.layout.projectDirectory
    include "${project.name}/build.gradle"
    include "${project.name}/src/**"
    into layout.buildDirectory.dir("course-downloadable")
}

tasks.named("assemble").configure {
    dependsOn tasks.named("downloadable")
}*/