package io.github.louistsaitszho.loft.localStorage

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

class SharedPreferenceManagerImpl(private val context: Context) : SharedPreferenceManager {

    companion object {
        const val PREFERENCE_ID = "loft"
        const val KEY_TOKEN = "token"
    }

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCE_ID, Context.MODE_PRIVATE)
    }

    override suspend fun isSignedIn(): Boolean = GlobalScope.async(Dispatchers.IO) {
        sharedPreference.contains(KEY_TOKEN)
    }.await()

    override suspend fun getToken(): String = GlobalScope.async {
        sharedPreference.getString(KEY_TOKEN, "")
    }.await()
}