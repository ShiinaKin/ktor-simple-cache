tasks.wrapper {
    gradleVersion = "8.8"
}

allprojects {

    group = "io.sakurasou.simple-cache"

    version = "0.4.5"

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        reports {
            junitXml.required.set(true)
        }
    }
}

