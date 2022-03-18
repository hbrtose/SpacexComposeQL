import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.jetbrains.kotlin.daemon.common.trimQuotes

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}

gradlePlugin {
    plugins {
        register("library") {
            id = "library"
            implementationClass = "plugin.Library"
        }
        register("feature") {
            id = "feature"
            implementationClass = "plugin.Feature"
        }
        register("injectable") {
            id = "injectable"
            implementationClass = "plugin.Injectable"
        }
        register("serialization") {
            id = "serialization"
            implementationClass = "plugin.Serialization"
        }
    }
}

tasks.getByName("compileKotlin") {
    val settingsFile = File("${project.rootDir.parent}/settings.gradle.kts")
    val moduleFile = File("${project.rootDir}/src/main/kotlin/Module.kt")

    val modules = settingsFile.bufferedReader().use { reader ->
        "include\\((.|\\n)*\\)".toRegex().find(reader.readText())!!.value
            .removeSurrounding("include(", ")")
            .split(",")
            .map { it.trim().trimQuotes().drop(1) }
    }

    val content = moduleFile.bufferedReader().use { reader ->
        val enums = modules.joinToString(",\n") { "${it.replace("-lib", "Lib")}(\":$it\")" }.prependIndent()
        reader.readText().replace("\\{(.|\\n)*\\}".toRegex(), "{\n$enums\n}")
    }

    moduleFile.writeText(content)
}
