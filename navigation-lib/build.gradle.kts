plugins {
    library
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    moduleImplementation(Module.COMMON)

    android()
    navigation()
}
