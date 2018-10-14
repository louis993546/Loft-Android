package io.github.louistsaitszho.loft.localStorage

interface SharedPreferenceManager {
    suspend fun isSignedIn(): Boolean

    suspend fun getToken(): String

    fun storeToken(token: String)
}