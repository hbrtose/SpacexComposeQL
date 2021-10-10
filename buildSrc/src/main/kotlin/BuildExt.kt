import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.androidConfig(configure: Action<BaseExtension>) {
    (this as ExtensionAware).extensions.configure("android", configure)
}

internal fun Project.android(configure: Action<LibraryExtension>) {
    (this as ExtensionAware).extensions.configure("android", configure)
}

internal fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
}

fun Project.addKotlinCompilerOptions(vararg compilerArg: String) {
    tasks.withType<KotlinCompile>().all {
        kotlinOptions.freeCompilerArgs += compilerArg.toList()
    }
}
internal fun DependencyHandler.implementation(name: Any) {
    add("implementation", name)
}

internal fun DependencyHandler.kapt(name: Any) {
    add("kapt", name)
}

internal fun DependencyHandler.compileOnly(name: Any) {
    add("compileOnly", name)
}

internal fun DependencyHandler.api(name: Any) {
    add("api", name)
}

internal fun DependencyHandler.testImplementation(name: Any) {
    add("testImplementation", name)
}

internal fun DependencyHandler.androidTestImplementation(name: Any) {
    add("androidTestImplementation", name)
}

fun DependencyHandler.moduleImplementation(module: Module) {
    implementation(project(module.id))
}
