import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    id("com.github.ben-manes.versions") version "0.44.0"

}

group = "com.chikli.adventofcode"
version = "1.0"

val jvmVersion: JavaLanguageVersion = JavaLanguageVersion.of(17)
java {
    toolchain {
        languageVersion.set(jvmVersion)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = jvmVersion.toString()
}
