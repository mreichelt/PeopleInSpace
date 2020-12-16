plugins {
    kotlin("multiplatform")
}

kotlin {
    macosX64("native") {
        binaries {
            executable()
        }
    }
}

dependencies {
    commonMainImplementation(project(":common"))
}
