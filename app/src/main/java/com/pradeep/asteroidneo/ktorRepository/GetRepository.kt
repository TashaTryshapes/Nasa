package com.pradeep.asteroidneo.ktorRepository

import com.pradeep.asteroidneo.network.KtorClient
import io.ktor.client.request.*

class GetRepository {
    suspend fun getComment(startingDate: String, endDate: String): String =
        KtorClient.httpClient.get<String> {
            url("https://api.nasa.gov/neo/rest/v1/feed")
            parameter("start_date", startingDate)
            parameter("end_date", endDate)
            parameter("api_key", "2YcjQHAEOfiKE2pkuzCtd2QGt7Ik8K5rtYsDLdyA")
        }

}