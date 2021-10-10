package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import android
import compose

class Feature : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply {
                plugin("library")
                plugin("kotlin-kapt")
                plugin("androidx.navigation.safeargs.kotlin")
            }

            android {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE
                    kotlinCompilerVersion = Versions.Kotlin.KOTLIN
                }
            }

            dependencies {
                android()
                compose()
            }
        }
    }
}