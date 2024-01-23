@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.application).apply(false)
    alias(libs.plugins.library).apply(false)
    alias(libs.plugins.android).apply(false)
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.multiplatform.resource).apply(false)
    alias(libs.plugins.composemultipleplatform).apply(false)
    alias(libs.plugins.kswift).apply(false)
    alias(libs.plugins.ksp).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

