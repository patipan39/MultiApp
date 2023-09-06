plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation("androidx.media3:media3-exoplayer:1.1.1")
                implementation("androidx.media3:media3-exoplayer-dash:1.1.1")
                implementation("androidx.media3:media3-ui:1.1.1")

                //koin
                api("io.insert-koin:koin-android:3.2.0")
            }
        }
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api("io.github.qdsfdhvh:image-loader:1.6.5")
                implementation("io.ktor:ktor-client-cio:2.3.4")

                //koin
                api("io.insert-koin:koin-core:3.2.0")
                api("io.insert-koin:koin-test:3.2.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting
    }
}

android {
    namespace = "com.dev.ipati.multiapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }

    sourceSets["main"].apply {
        res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    }
}