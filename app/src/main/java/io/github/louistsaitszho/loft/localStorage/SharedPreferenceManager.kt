package io.github.louistsaitszho.loft.localStorage

interface SharedPreferenceManager {
    fun isSignedIn(): Boolean

    fun getToken(): String

    fun storeToken(token: String)
}