package io.github.louistasitszho.loft.common.localStorage

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManagerImpl(private val context: Context) : SharedPreferenceManager {

    companion object {
        const val PREFERENCE_ID = "loft"
        const val KEY_TOKEN = "token"
    }

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCE_ID, Context.MODE_PRIVATE)
    }

    override suspend fun isSignedIn(): Boolean = sharedPreference.contains(KEY_TOKEN)

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override suspend fun getToken(): String = sharedPreference.getString(KEY_TOKEN, "")

    override suspend fun storeToken(token: String) {
        sharedPreference.edit().putString(KEY_TOKEN, token).apply()
    }
}