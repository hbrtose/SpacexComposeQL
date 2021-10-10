import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    object GradlePlugins {
        const val BUILD = "com.android.tools.build:gradle:${Versions.GradlePlugins.BUILD}"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.GradlePlugins.KOTLIN}"
        const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.DI.HILT}"
        const val SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Navigation.NAVIGATION}"
        const val SERIALIZATION = "org.jetbrains.kotlin:kotlin-serialization:${Versions.Kotlin.KOTLIN}"
        const val APOLLO = "com.apollographql.apollo"
    }

    object Android {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.Android.CORE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Android.APP_COMPAT}"
        const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.LIVEDATA_KTX}"
        const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.LIVEDATA_KTX}"
        const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.LIVEDATA_KTX}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.Android.FRAGMENT_KTX}"
    }

    object Compose {
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.Compose.COMPOSE}"
        const val LAYOUT = "androidx.compose.foundation:foundation-layout:${Versions.Compose.COMPOSE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.Compose.COMPOSE}"
        const val MATERIAL_ICONS_EXTENDED = "androidx.compose.material:material-icons-extended:${Versions.Compose.COMPOSE}"
        const val RUNTIME = "androidx.compose.runtime:runtime:${Versions.Compose.COMPOSE}"
        const val RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Versions.Compose.COMPOSE}"
        const val TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE}"
        const val UI_TEST = "androidx.compose.ui:ui-test:${Versions.Compose.COMPOSE}"
        const val COIL = "io.coil-kt:coil-compose:${Versions.Compose.COIL}"
    }

    object DI {
        const val HILT = "com.google.dagger:hilt-android:${Versions.DI.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.DI.HILT}"
    }

    object Kotlin {
        const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.KOTLIN}"
        const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.COROUTINES}"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.COROUTINES}"
    }

    object Navigation {
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.NAVIGATION}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.Navigation.NAVIGATION}"
    }

    object Network {
        const val APOLLO_RUNTIME = "com.apollographql.apollo:apollo-runtime:${Versions.Network.APOLLO}"
        const val APOLLO_COROUTINES = "com.apollographql.apollo:apollo-coroutines-support:${Versions.Network.APOLLO}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.Test.JUNIT_EXT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
    }
}

fun DependencyHandler.android() {
    implementation(Dependencies.Android.CORE_KTX)
    implementation(Dependencies.Android.APP_COMPAT)
    implementation(Dependencies.Android.LIFECYCLE_KTX)
    implementation(Dependencies.Android.LIVEDATA_KTX)
    implementation(Dependencies.Android.VIEWMODEL_KTX)
    implementation(Dependencies.Android.FRAGMENT_KTX)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.Compose.FOUNDATION)
    implementation(Dependencies.Compose.LAYOUT)
    implementation(Dependencies.Compose.MATERIAL)
    implementation(Dependencies.Compose.MATERIAL_ICONS_EXTENDED)
    implementation(Dependencies.Compose.RUNTIME)
    implementation(Dependencies.Compose.RUNTIME_LIVEDATA)
    implementation(Dependencies.Compose.TOOLING)
    implementation(Dependencies.Compose.COIL)
    androidTestImplementation(Dependencies.Compose.UI_TEST)
}

fun DependencyHandler.di() {
    implementation(Dependencies.DI.HILT)
    kapt(Dependencies.DI.HILT_COMPILER)
}

fun DependencyHandler.kotlin() {
    implementation(Dependencies.Kotlin.KOTLIN_STD_LIB)
    implementation(Dependencies.Kotlin.COROUTINES_CORE)
    implementation(Dependencies.Kotlin.COROUTINES_ANDROID)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUI)
}

fun DependencyHandler.network() {
    implementation(Dependencies.Network.APOLLO_COROUTINES)
    implementation(Dependencies.Network.APOLLO_RUNTIME)
}

fun DependencyHandler.unitTest() {
    testImplementation(Dependencies.Test.JUNIT)
}

fun DependencyHandler.androidTest() {
    androidTestImplementation(Dependencies.Test.JUNIT_EXT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
}