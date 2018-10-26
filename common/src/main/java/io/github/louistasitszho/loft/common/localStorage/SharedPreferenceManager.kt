package io.github.louistasitszho.loft.common.localStorage

interface SharedPreferenceManager {
    fun isSignedIn(): Boolean

    fun getToken(): String

    fun storeToken(token: String)
}