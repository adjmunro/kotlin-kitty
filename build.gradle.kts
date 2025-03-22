import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
    `maven-publish`
}

group = "nz.adjmunro.kty"
version = libs.versions.kty.library.get()

java {
    withJavadocJar() // TODO set up dokka
    withSourcesJar()
}

kotlin {
    explicitApi()
    jvmToolchain(libs.versions.java.language.get().toInt())

    compilerOptions {
        // Target version of the generated JVM bytecode.
        jvmTarget = JvmTarget.fromTarget(target = libs.versions.java.language.get())

        // Free compiler args (e.g., experimental -X flags).
        freeCompilerArgs.addAll(
            // Suppressed Warnings
            // "-Xsuppress-warning=",
            "-opt-in=kotlin.experimental.ExperimentalTypeInference",
        )

        // Enable extra K2 warnings.
        extraWarnings = true
    }
}

sourceSets {
    val main by getting { kotlin.srcDirs("src/main/kotlin") }
    val test by getting { kotlin.srcDirs("src/test/kotlin") }
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>(name = "kty-maven-artifact") {
            from(components["kotlin"])
            groupId = "nz.adjmunro"
            artifactId = "kty"
            version = libs.versions.kty.library.get()
        }
    }
    repositories {
        mavenLocal()

//       TODO
//        maven {
//            name = "GitHubPackages"
//            url = uri("https://maven.pkg.github.com/adjmunro/kty")
//            credentials {
//                username = System.getenv("GITHUB_ACTOR")
//                password = System.getenv("GITHUB_TOKEN")
//            }
//        }
    }
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(libs.kotlin.stdlib)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotest.property)
    testImplementation(libs.kotest.assertions)
}
