package plugin

import di
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class Injectable : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply {
                plugin("kotlin-kapt")
                plugin("dagger.hilt.android.plugin")
            }

            dependencies {
                di()
            }
        }
    }
}
