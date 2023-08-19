package com.ucasoft.ktor.simpleCache

import io.ktor.content.*
import io.ktor.server.application.*
import io.ktor.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

class SimpleCacheConfig {

    internal var provider: SimpleCacheProvider = SimpleMemoryCacheProvider(SimpleMemoryCacheProvider.Config())
}

class SimpleCache(internal var config: SimpleCacheConfig) {

    companion object : BaseApplicationPlugin<Application, SimpleCacheConfig, SimpleCache> {
        override val key: AttributeKey<SimpleCache> = AttributeKey("SimpleCacheHolder")

        override fun install(pipeline: Application, configure: SimpleCacheConfig.() -> Unit): SimpleCache {
            return SimpleCache(SimpleCacheConfig().apply { configure })
        }
    }
}

abstract class SimpleCacheProvider(config: Config) {

    val invalidateAt = config.invalidateAt

    abstract fun getCache(key: String): Any?

    abstract fun setCache(key: String, content: Any, invalidateAt: Duration?)

    open class Config protected constructor() {

         var invalidateAt: Duration = 5.minutes
    }
}

fun SimpleCacheConfig.memoryCache(
    configure : SimpleMemoryCacheProvider.Config.() -> Unit
){
    provider = SimpleMemoryCacheProvider(SimpleMemoryCacheProvider.Config().apply { configure })
}