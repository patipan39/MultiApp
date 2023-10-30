plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

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
                implementation("androidx.media3:media3-exoplayer:1.1.1")
                implementation("androidx.media3:media3-exoplayer-dash:1.1.1")
                implementation("androidx.media3:media3-ui:1.1.1")

                //koin
                api("io.insert-koin:koin-android:3.5.0")
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
                api("io.insert-koin:koin-core:3.5.0")
                api("io.insert-koin:koin-test:3.5.0")

                // compose multiplatform
                api("dev.icerock.moko:mvvm-compose:0.16.1") // api mvvm-core, getViewModel for Compose Multiplatfrom
                api("dev.icerock.moko:mvvm-flow-compose:0.16.1") // api mvvm-flow, binding extensions for Compose Multiplatfrom
                api("dev.icerock.moko:mvvm-livedata-compose:0.16.1")

                //viewModel
                api("dev.icerock.moko:mvvm-core:0.16.1")

                api("me.dmdev.premo:premo:1.0.0-alpha.11")
                api("me.dmdev.premo:premo-navigation:1.0.0-alpha.11")
                api("me.dmdev.premo:premo-saver-json:1.0.0-alpha.11")

                api("dev.icerock.moko:resources:0.23.0")
                api("dev.icerock.moko:resources-compose:0.23.0")
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
    //old implement
//    sourceSets["main"].apply {
//        res.srcDirs("src/androidMain/res", "src/commonMain/resources")
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.multi.resource"
    multiplatformResourcesClassName = "SharedRes"
}