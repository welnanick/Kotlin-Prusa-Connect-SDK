plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.plugin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
}

group = "com.nickwelna"
version = "0.1.0"

repositories {
    mavenCentral()
}


dependencies {
    implementation(libs.annotations)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktorfit.lib.light)
    implementation(libs.okio)

    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter.api)
}

tasks.test {
    useJUnitPlatform()
}
