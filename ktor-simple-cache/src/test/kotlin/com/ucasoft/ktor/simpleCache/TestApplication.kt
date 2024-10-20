package com.ucasoft.ktor.simpleCache

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random

fun Application.badTestApplication() {

    install(SimpleCache) {
    }

    routing {
        cacheOutput {
            get("/check") {
                call.respondText("Check response")
            }
        }
    }
}

fun Application.testApplication() {

    routing {
        cacheOutput {
            get("/check") {
                call.respondText(Random.nextInt().toString())
            }
            get("/bad") {
                call.respond(HttpStatusCode.BadRequest, "Bad request")
            }
            get("/exception") {
                throw RuntimeException("Just an exception")
            }
        }
    }
}

fun Application.testApplicationWithKeys() {
    routing {
        cacheOutput(queryKeys = listOf("param1", "param3")) {
            get("/check") {
                call.respondText(Random.nextInt().toString())
            }
        }
    }
}

fun SimpleCacheConfig.testCache(
    testProvider : SimpleCacheProvider
){
    provider = testProvider
}