rootProject.name = "kty"

pluginManagement {
    /**
     * The pluginManagement -> repositories block configures the repositories Gradle uses to search
     * for and download Gradle plugins. You can also use local repositories or define your own remote.
     */
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }

    /** Plugins applied to all modules in the project, that may be needed early in configuration(?) */
    plugins {
        // TODO: Use this block to apply plugins for linting gradle files
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    /**
     * The dependencyResolutionManagement -> repositories block is where you configure the source
     * repositories for all dependencies used by modules in your project. However, you should
     * configure module-specific dependencies in each module-level build.gradle.kts file.
     */
    repositories {
        mavenCentral()
        google()
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs.create("libs")
}
