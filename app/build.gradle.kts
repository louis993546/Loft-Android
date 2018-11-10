import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(project.ext["compile_sdk_version"] as Int)
    defaultConfig {
        applicationId = "io.github.louistsaitszho.loft"
        minSdkVersion(project.ext["min_sdk_version"] as Int)
        targetSdkVersion(project.ext["target_sdk_version"] as Int)
        versionCode = 2
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        resConfigs("en")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dataBinding {
        isEnabled = true
    }
}

//TODO temporary workaround: https://github.com/gradle/kotlin-dsl/issues/644#issuecomment-398502551
androidExtensions {
    configure(delegateClosureOf<AndroidExtensionsExtension> {
        isExperimental = true
    })
}

dependencies {
    implementation(project(":common"))
    implementation(project(":api"))
    implementation(project(":database"))
    implementation(project(":onboarding"))

    val supportLibraryVersion = "27.1.1"
    implementation("com.android.support:support-v4:$supportLibraryVersion")
    implementation("com.android.support:cardview-v7:$supportLibraryVersion")
    implementation("com.android.support:customtabs:$supportLibraryVersion")

    val navigationVersion = "1.0.0-alpha07"
    implementation("android.arch.navigation:navigation-fragment:$navigationVersion")
    implementation("android.arch.navigation:navigation-ui:$navigationVersion")
    implementation("android.arch.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("android.arch.navigation:navigation-ui-ktx:$navigationVersion")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")

    implementation("com.jakewharton.threetenabp:threetenabp:1.1.1")

    val lifecycleVersion = "1.1.1"
    implementation("android.arch.lifecycle:extensions:$lifecycleVersion")
    implementation("android.arch.lifecycle:common-java8:$lifecycleVersion")
    testImplementation("android.arch.core:core-testing:$lifecycleVersion")

    val pagingVersion = "1.0.0"
    implementation("android.arch.paging:runtime:$pagingVersion")
    testImplementation("android.arch.paging:common:$pagingVersion")
}
