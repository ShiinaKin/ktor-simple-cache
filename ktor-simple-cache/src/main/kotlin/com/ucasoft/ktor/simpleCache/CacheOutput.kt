package com.ucasoft.ktor.simpleCache

import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlin.time.Duration

class CacheOutputSelector : RouteSelector() {

    override fun evaluate(context: RoutingResolveContext, segmentIndex: Int) = RouteSelectorEvaluation.Transparent
}

/**
 * @param onlyMatchQueryKeys if true, only cache the response when any query params of request are contained in queryKeys, and only use the matching query params to construct the cacheKey.
 */
fun Route.cacheOutput(
    invalidateAt: Duration? = null,
    queryKeys: List<String> = emptyList(),
    onlyMatchQueryKeys: Boolean = false,
    build: Route.() -> Unit
): Route {
    val route = createChild(CacheOutputSelector())
    route.install(SimpleCachePlugin) {
        this.invalidateAt = invalidateAt
        this.queryKeys = queryKeys
        this.onlyMatchQueryKeys = onlyMatchQueryKeys
    }
    route.build()
    return route
}