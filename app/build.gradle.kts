plugins {
    id("com.android.application")
    id(Dependencies.GradlePlugins.APOLLO).version(Versions.Network.APOLLO)
    kotlin("android")
    injectable
}

android {
    compileSdk = Config.compileSdkVersion
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.androidTestInstrumentation

    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE
    }
}

dependencies {
    implementProjectModules()
    android()
    compose()
    kotlin()
    navigation()
    network()
    unitTest()
    androidTest()
}

fun DependencyHandler.implementProjectModules() {
    Module.values().filter { it != Module.APP }.forEach { module ->
        moduleImplementation(module)
    }
}