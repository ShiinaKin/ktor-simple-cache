tasks.wrapper {
    gradleVersion = "8.8"
}

allprojects {

    group = "com.ucasoft.ktor"

    version = "0.4.4"

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        reports {
            junitXml.required.set(true)
        }
    }
}