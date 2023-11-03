import org.jetbrains.compose.compose

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.dev.ipati.multiapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.dev.ipati.multiapp.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compileversion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.compose.android.ui)
    implementation(libs.compose.android.tools)
    implementation(libs.compose.android.preview)
    implementation(libs.compose.android.material)
    implementation(libs.compose.android.foundation)
    implementation(libs.compose.android.activity)
}