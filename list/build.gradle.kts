plugins {
    feature
    injectable
}

dependencies {
    moduleImplementation(Module.COMMON)
    moduleImplementation(Module.LIST_LIB)
    moduleImplementation(Module.NAVIGATION)

    navigation()
}
