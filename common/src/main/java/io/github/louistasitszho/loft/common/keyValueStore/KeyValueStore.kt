package io.github.louistasitszho.loft.common.keyValueStore

/**
 * Definition of what a simple key-value store should be able to do
 */
interface KeyValueStore {
    suspend fun isSignedIn(): Boolean

    suspend fun getToken(): String

    suspend fun storeToken(token: String)
}