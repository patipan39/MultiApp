pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        //for get compose compiler for kotlin 1.9.20
        maven {
            url = uri("https://androidx.dev/storage/compose-compiler/repository/")
        }
    }
}

rootProject.name = "MultiApp"
include(":androidApp")
include(":shared")