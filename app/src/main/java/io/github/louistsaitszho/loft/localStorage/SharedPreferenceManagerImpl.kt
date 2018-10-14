package io.github.louistsaitszho.loft.localStorage

import android.content.Context
import android.content.SharedPreferences

/**
 * TODO remove GlobalScope. Find out how to "pass" the scope of whoever is using it
 */
class SharedPreferenceManagerImpl(private val context: Context) : SharedPreferenceManager {

    companion object {
        const val PREFERENCE_ID = "loft"
        const val KEY_TOKEN = "token"
    }

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCE_ID, Context.MODE_PRIVATE)
    }

    override fun isSignedIn(): Boolean = sharedPreference.contains(KEY_TOKEN)

    override fun getToken(): String = sharedPreference.getString(KEY_TOKEN, "")

    override fun storeToken(token: String) {
        sharedPreference.edit().putString(KEY_TOKEN, token).apply()
    }
}