plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "org.insbaixcamp.fitnessappb"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "org.insbaixcamp.fitnessappb"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

configurations.all {
    resolutionStrategy.force("org.jetbrains.kotlin:kotlin-stdlib:2.2.10")
    resolutionStrategy.force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.2.10")
    resolutionStrategy.force("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.2.10")
    resolutionStrategy.force("org.jetbrains.kotlin:kotlin-reflect:2.2.10")
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation(
        "com.squareup.retrofit2:converter-gson:3.0.0"
    )
    implementation("io.coil-kt.coil3:coil-compose:3.6.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.3")
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation("androidx.compose.material:material-icons-extended")
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}