// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val support_library_version = "27.1.1"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    val compile_sdk_version by extra { 28 }
    val min_sdk_verion by extra { 21 }
    val target_sdk_version by extra { 27 }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
