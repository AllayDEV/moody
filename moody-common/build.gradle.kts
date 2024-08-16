plugins {
    alias(shared.plugins.kotlin)
    alias(shared.plugins.google.devtools)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(shared.squareup.moshi)
}