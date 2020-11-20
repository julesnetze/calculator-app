plugins {
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.http4k", "http4k-core", "3.278.0")
    implementation("org.http4k","http4k-client-okhttp", "3.278.0")

    testImplementation("org.http4k","http4k-client-apache", "3.278.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.2")
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.6.2")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
