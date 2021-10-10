plugins {
    library
    injectable
    id(Dependencies.GradlePlugins.APOLLO).version(Versions.Network.APOLLO)
}

dependencies {
    network()
}

apollo {
    generateKotlinModels.set(true)
}