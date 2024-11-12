import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentOperatingSystem

plugins {
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

val platform = when {
    getCurrentOperatingSystem().isWindows -> "win"
    getCurrentOperatingSystem().isLinux -> "linux"
    getCurrentOperatingSystem().isMacOsX -> "mac"
    else -> throw UnsupportedOperationException("Operating system ${getCurrentOperatingSystem()} not supported yet")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(group = "org.openjfx", name = "javafx-base", version = "23", classifier = platform)
    implementation(group = "org.openjfx", name = "javafx-graphics", version = "23", classifier = platform)
    implementation(group = "org.openjfx", name = "javafx-controls", version = "23", classifier = platform)
    implementation(group = "org.openjfx", name = "javafx-fxml", version = "23", classifier = platform)
    implementation(group = "org.openjfx", name = "javafx-web", version = "23", classifier = platform)
    implementation("org.controlsfx:controlsfx:11.1.1")
    implementation("org.kordamp.ikonli:ikonli-javafx:12.3.1")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.9.3")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

application {
    mainClass = "org.FxApp.AppRunner"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "org.FxApp.AppRunner"
        )
    }
}

tasks.shadowJar {
    archiveBaseName.set("AppFX")
    archiveVersion.set("1.0-SNAPSHOT")
    mergeServiceFiles()
    destinationDirectory.set(file("$buildDir/libs"))
}
