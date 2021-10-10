plugins {
    feature
    injectable
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    moduleImplementation(Module.COMMON)
    moduleImplementation(Module.DETAIL_LIB)
    moduleImplementation(Module.NAVIGATION)
    navigation()
}
