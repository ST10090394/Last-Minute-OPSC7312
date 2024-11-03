buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false // Updating Gradle Plugin to 8.1.0 for compatibility with newer Kotlin
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false // Updated Kotlin version to match dependencies
    id("com.google.gms.google-services") version "4.4.2" apply false
}
