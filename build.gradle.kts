import dev.slne.surf.surfapi.gradle.util.slneReleases

plugins {
    id("dev.slne.surf.surfapi.gradle.core") version "1.21.4+"
}

group = "dev.slne.surf"
version = findProperty("version") as String

dependencies {
    api(libs.bundles.exposed) {
        exclude("org.jetbrains.kotlin", "kotlin-stdlib")
        exclude("org.jetbrains.kotlin", "kotlin-reflect")
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-core")
        exclude("org.slf4j", "slf4j-api")
    }
    api(libs.hikari)

    runtimeOnly(libs.sqlite)
    runtimeOnly(libs.mariadb)
}

kotlin {
    jvmToolchain(21)
}

publishing {
    repositories {
        slneReleases()
    }
}