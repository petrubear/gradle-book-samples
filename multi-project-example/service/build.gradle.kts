plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

repositories {
    mavenCentral()
}
