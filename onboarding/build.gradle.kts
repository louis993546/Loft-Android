plugins {
    id("com.android.library")
    id("kotlin-android-extensions")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(project.ext["compile_sdk_version"] as Int)
    defaultConfig {
        minSdkVersion(project.ext["min_sdk_version"] as Int)
        targetSdkVersion(project.ext["target_sdk_version"] as Int)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    flavorDimensions("server")
    productFlavors {
        create("local") {
            setDimension("server")
        }
        create("staging") {
            setDimension("server")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":api"))

    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}
