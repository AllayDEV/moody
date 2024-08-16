plugins {
    alias(shared.plugins.kotlin)
}

group = property("project.group")!!
version = property("project.version")!!

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

allprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    kotlin {
        jvmToolchain(21)
    }

}