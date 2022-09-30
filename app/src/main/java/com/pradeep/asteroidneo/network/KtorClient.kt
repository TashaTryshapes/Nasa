package com.pradeep.asteroidneo.network

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

object KtorClient {

    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
        isLenient = true
    }

    val httpClient = HttpClient(Android) {
        install(HttpTimeout) {
            socketTimeoutMillis = 30000
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 30000
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.e("Ktor Http Request", message.trim())
                }
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

}