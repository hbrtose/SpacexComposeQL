// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Dependencies.GradlePlugins.BUILD)
        classpath(Dependencies.GradlePlugins.KOTLIN)
        classpath(Dependencies.GradlePlugins.HILT)
        classpath(Dependencies.GradlePlugins.SAFE_ARGS)
        classpath(Dependencies.GradlePlugins.SERIALIZATION)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}