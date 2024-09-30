plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.carspotteropsc7312poe"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.carspotteropsc7312poe"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))

    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    // Firebase Auth
    implementation ("com.google.firebase:firebase-auth-ktx:21.2.0")

    // Google Play Services Auth
    implementation ("com.google.android.gms:play-services-auth:20.2.0")

    // For Google Identity One Tap Sign-In
    implementation ("com.google.android.gms:play-services-identity:17.0.0")

    // Firebase libraries without specific versions
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-database-ktx")

    // GSON
    implementation("com.google.code.gson:gson:2.10.1")

    // Google Location Services
    implementation("com.google.android.gms:play-services-location:21.3.0")
    implementation("com.squareup.picasso:picasso:2.8") // Use the latest version available
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.mapbox.maps:android:10.10.0")
    implementation(libs.core.ktx)

    // AndroidX test libraries
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    // JUnit
    testImplementation ("junit:junit:4.13.2")

    // Espresso for UI testing
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.5.1")

    // ActivityTestRule for managing activity lifecycle in tests
    androidTestImplementation ("androidx.test:rules:1.5.0")
    // Circle Image
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // AndroidX dependencies
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Weather API dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
}
