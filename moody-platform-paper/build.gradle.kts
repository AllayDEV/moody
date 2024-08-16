import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    alias(shared.plugins.kotlin)
    alias(shared.plugins.modrinth.minotaur)
    alias(shared.plugins.johnrengelman.shadow)

    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.3.0"
}

repositories {
    mavenCentral()
    maven("https://libraries.minecraft.net")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(shared.kotlin.stdlib)
    implementation(project(":moody-common"))

    compileOnly("io.papermc.paper", "paper-api", "1.20.4-R0.1-SNAPSHOT")
}

modrinth {
    token = property("modrinth.token")?.toString()
        ?: error("modrinth.token property was not set")

    projectId.set("allay-moody")
    versionType.set("release")
    versionNumber.set(project.parent?.version.toString())
    loaders.addAll("paper", "folia")
    gameVersions.addAll(
        "1.19", "1.20", "1.21",
    )

    uploadFile.set(tasks.shadowJar)
    syncBodyFrom = rootProject.file("README.md").readText()
}

paper {
    name = "moody"
    prefix = "Moody"
    description = "An emoticon plugin that shows the mood of the players"

    main = "dev.allay.moody.PaperMoody"
    version = project.parent?.version.toString()
    apiVersion = "1.19"

    author = "AllayDEV"
    website = "https://github.com/AllayDEV/moody"

    foliaSupported = true
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
}

tasks {
    runServer {
        minecraftVersion("1.21")
    }
}