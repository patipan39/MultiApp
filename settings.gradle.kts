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
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
    }
}

rootProject.name = "MultiApp"
include(":androidApp")
include(":shared")