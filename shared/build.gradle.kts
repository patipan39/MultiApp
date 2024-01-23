@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.library)
    alias(libs.plugins.composemultipleplatform)
    alias(libs.plugins.multiplatform.resource)
    alias(libs.plugins.kotlinserialization)
    alias(libs.plugins.kswift)
    alias(libs.plugins.kotest)
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

            export(libs.compose.core)
            export(libs.moko.livedata)
            export(libs.compose.livedata.resource)
            export(libs.compose.mvvm.state)
        }
    }

    sourceSets {
        androidMain {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.media3.exoplayer)
                implementation(libs.media3.exoplayer.dash)
                implementation(libs.media3.ui)
                implementation(libs.ktor.client.okttp)
                implementation(libs.coroutine.android)
                implementation(libs.koin.android)
                implementation(libs.compose.android.material3)
            }
        }

        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.material)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            //koin
            implementation(libs.koin.core)
            implementation(libs.koin.test)

            // compose multiplatform
            api(libs.compose.mvvm) // api mvvm-core, getViewModel for Compose Multiplatfrom
            api(libs.compose.flow) // api mvvm-flow, binding extensions for Compose Multiplatfrom
            api(libs.compose.livedata)
            api("dev.icerock.moko:kswift-runtime:0.6.1")

            api(libs.compose.core) // only ViewModel, EventsDispatcher, Dispatchers.UI
            api(libs.moko.flow) // api mvvm-core, CFlow for native and binding extensions
            api(libs.compose.livedata.resource) // api mvvm-core, LiveData and extensions
            api(libs.compose.mvvm.state)// api mvvm-livedata, ResourceState class and extensions
            api(libs.moko.livedata) // api mvvm-core, moko-resources, extensions for LiveData with moko-resources
            api(libs.moko.flowresource) // api mvvm-core, moko-resources, extensions for Flow with moko-resources

            implementation(libs.moko.resource)
            implementation(libs.moko.compose)

            implementation(libs.ktor.client)
            implementation(libs.ktor.client.core)
            implementation(libs.coroutine.core)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.cbor)
            implementation(libs.ktor.protobuf)
            implementation(libs.ktor.negotiation)

            implementation(libs.kamel.image)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.coroutine.test)
            implementation(libs.kotest.engine)
            implementation(libs.kotest.assertion)
            implementation(libs.kotest.property)
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compileversion.get()
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.multi.resource"
    multiplatformResourcesClassName = "SharedRes"
    disableStaticFrameworkWarning = true
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.skiko:skiko:0.7.85.4")
    }
}