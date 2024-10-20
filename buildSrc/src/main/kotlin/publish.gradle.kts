plugins {
    `maven-publish`
    signing
}

val libraryData = extensions.create("libraryData", PublishingExtension::class)

val stubJavadoc by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    publications.configureEach {
        if (this is MavenPublication) {
            if (name != "kotlinMultiplatform") {
                artifact(stubJavadoc)
            }
            pom {
                name.set(libraryData.name)
                description.set(libraryData.description)
                url.set("https://github.com/ShiinaKin/ktor-simple-cache")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("ShiinaKin")
                        name.set("Shiina Kin")
                        email.set("shiina@sakurasou.io")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/ShiinaKin/ktor-simple-cache.git")
                    developerConnection.set("scm:git:ssh://github.com:ShiinaKin/ktor-simple-cache.git")
                    url.set("https://github.com/ShiinaKin/ktor-simple-cache")
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ShiinaKin/ktor-simple-cache")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("PAT")
            }
        }
    }
}

tasks.withType<AbstractPublishToMaven>().configureEach {
    val signingTasks = tasks.withType<Sign>()
    mustRunAfter(signingTasks)
}