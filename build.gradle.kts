import org.gradle.accessors.dm.LibrariesForLibs.VersionAccessors
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
    jacoco
    `maven-publish`
}

private val Project.semver: String by lazy {
    val major = version { project.version.major }
    val minor = version { project.version.minor }
    val patch = version { project.version.patch }
    return@lazy "$major.$minor.$patch"
}

private fun Project.version(selector: VersionAccessors.() -> Provider<String>): String {
    return this@version.libs.versions.selector().get()
}

group = version { project.group }
version = semver

java {
    sourceCompatibility = JavaVersion.toVersion(version { java.toolchain })
    targetCompatibility = JavaVersion.toVersion(version { java.bytecode })

    withJavadocJar() // TODO set up dokka
    withSourcesJar()
}

kotlin {
    // Require explicit visibility & return types.
    explicitApi()

    // JDK version used by compiler & tooling.
    jvmToolchain(version { java.toolchain } .toInt())

    compilerOptions {
        // Target version of the generated JVM bytecode.
        jvmTarget = JvmTarget.fromTarget(target = version { java.bytecode })

        // Free compiler args, if necessary (e.g., experimental -X flags).
        freeCompilerArgs.addAll()

        // Enable extra K2 warnings.
        extraWarnings = true
    }
}

sourceSets {
    val main by getting { kotlin.srcDirs("src/main/kotlin") }
    val test by getting { kotlin.srcDirs("src/test/kotlin") }
}

tasks.wrapper {
    gradleVersion = "latest"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    reports {
        junitXml.required = true
        html.required = true
    }
}
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
        html.required = true
        html.outputLocation = layout.buildDirectory.dir("reports/jacoco/html")
    }
}
jacoco {
    reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}

publishing {
    publications {
        create<MavenPublication>(name = "kty-maven-artifact") {
            from(components["kotlin"])
            groupId = version { project.groupid }
            artifactId = version { project.artifactid }
            version = semver
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

    testImplementation(libs.bundles.test)
}
