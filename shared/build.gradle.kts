@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.library)
    alias(libs.plugins.composemultipleplatform)
    alias(libs.plugins.multiplatform.resource)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            binaryOption("bundleId", "com.dev.ipati.multiapp.shared")
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val androidMain by getting {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.media3.exoplayer)
                implementation(libs.media3.exoplayer.dash)
                implementation(libs.media3.ui)
                implementation(libs.ktor.client.okttp)
                implementation(libs.coroutine.android)
                implementation(libs.koin.android)
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

                implementation(libs.image.loader)
                implementation(libs.ktor.client)

                //koin
                implementation(libs.koin.core)
                implementation(libs.koin.test)

                // compose multiplatform
                implementation(libs.compose.mvvm) // api mvvm-core, getViewModel for Compose Multiplatfrom
                implementation(libs.compose.flow) // api mvvm-flow, binding extensions for Compose Multiplatfrom
                implementation(libs.compose.livedata)

                //viewModel
                implementation(libs.compose.core)

                implementation(libs.moko.resource)
                implementation(libs.moko.compose)

                implementation(libs.ktor.client.core)
                implementation(libs.coroutine.core)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.dev.ipati.multiapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.multi.resource"
    multiplatformResourcesClassName = "SharedRes"
}