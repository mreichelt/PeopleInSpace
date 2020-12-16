plugins {
    kotlin("multiplatform")
}

kotlin {
    linuxX64("native") {
        binaries {
            executable()
        }
    }
}

dependencies {
    commonMainImplementation(project(":common"))
}
