tasks.wrapper {
    gradleVersion = "8.8"
}

allprojects {

    group = "io.sakurasou.ktor"

    version = "0.4.6"

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        reports {
            junitXml.required.set(true)
        }
    }
}

