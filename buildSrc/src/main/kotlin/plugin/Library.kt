package plugin

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import android
import kotlinOptions
import kotlin

class Library : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply {
                plugin("com.android.library")
                plugin("kotlin-android")
            }

            android {
                compileSdk = Config.compileSdkVersion
                buildToolsVersion = Config.buildToolsVersion

                defaultConfig {
                    targetSdk = Config.compileSdkVersion
                    minSdk = Config.minSdkVersion

                    versionCode = Config.versionCode
                    versionName = Config.versionName

                    consumerProguardFiles("consumer-rules.pro")
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                kotlinOptions {
                    jvmTarget = Config.jvmTarget
                }
            }

            dependencies {
                kotlin()
            }
        }
    }
}