package io.github.louistasitszho.loft.common.localStorage

interface SharedPreferenceManager {
    suspend fun isSignedIn(): Boolean

    suspend fun getToken(): String

    suspend fun storeToken(token: String)
}