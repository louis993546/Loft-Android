// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
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
    //TODO see if there is a type-safe way to use extra properties
    ext {
        set("compile_sdk_version", 27)
        set("min_sdk_version", 21)
        set("target_sdk_version", 27)
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
