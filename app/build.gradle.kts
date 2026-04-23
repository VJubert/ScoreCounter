plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "fr.vju.scorecounter"
    compileSdk = 37

    defaultConfig {
        applicationId = "fr.vju.scorecounter"
        minSdk = 23
        targetSdk = 37
        versionCode = 3
        versionName = "1.2"

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
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
}