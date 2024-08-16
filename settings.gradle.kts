dependencyResolutionManagement {
    versionCatalogs {
        create("shared") {
            from(files("./gradle/shared.versions.toml"))
        }
    }
}

rootProject.name = "moody"

include(
    "moody-common",
)

include(
    "moody-platform-paper",
)