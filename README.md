# Ktor Simple Cache

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Scogun_ktor-simple-cache&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Scogun_ktor-simple-cache) ![GitHub](https://img.shields.io/github/license/Scogun/ktor-simple-cache?color=blue) ![Publish workflow](https://github.com/Scogun/ktor-simple-cache/actions/workflows/publish.yml/badge.svg) [![Maven Central with version prefix filter](https://img.shields.io/maven-central/v/com.ucasoft.kcron/ktor-simple-cache/0.0.8?color=blue)](https://search.maven.org/artifact/com.ucasoft.kcron/ktor-simple-cache/0.0.8/jar)

This repository hosts a number of libraries for [Ktor](https://ktor.io/) Server to simply add output cache.

To learn more please refer to the `README`s of individual library.

| README                                                         |
|:---------------------------------------------------------------|
| [ktor-simple-cache](ktor-simple-cache/README.md)               |
| [ktor-simple-memory-cache](ktor-simple-memory-cache/README.md) |
| [ktor-simple-redis-cache](ktor-simple-redis-cache/README.md)   |

## Using in Your Projects

Use one of simple cache provider library to setup cache during server configuration:

```kotlin
install(SimpleCache) {
    //cacheProvider {}
}
```