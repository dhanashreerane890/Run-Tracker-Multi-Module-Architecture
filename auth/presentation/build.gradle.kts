plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.anywhere.auth.presentation"
    compileSdk = 36

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

}

tasks.withType<Test>() {
    useJUnit()
}

dependencies {

    implementation(projects.core.presentation.designsystem)
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.presentation.ui)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation.layout)

    implementation(libs.koin.core)

    implementation(libs.koin.android)

    implementation(libs.koin.android.workmanager)

    implementation(libs.koin.androidx.compose)


    // JUnit 5
//    testImplementation(libs.junit.jupiter.api)
//    testImplementation(libs.junit.jupiter.engine)
//    testImplementation(libs.junit.jupiter.params)

//    testImplementation(libs.junit)
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.13")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")


    // Coroutines Test
    testImplementation(libs.kotlinx.coroutines.test)

    // MockK
//    testImplementation(libs.mockk)


}