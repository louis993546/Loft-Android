package io.github.louistsaitszho.loft.common.keyValueStore

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Implementation of Key-Value store, powered by SharedPreference
 */
class KeyValueStoreImpl(private val context: Context) : KeyValueStore {
    private var temporaryFakeToken: String? = null

    companion object {
        const val PREFERENCE_ID = "loft"
        const val KEY_TOKEN = "token"
    }

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCE_ID, Context.MODE_PRIVATE)
    }

    //    override suspend fun isSignedIn(): Boolean = sharedPreference.contains(KEY_TOKEN)
    override suspend fun isSignedIn(): Boolean = !temporaryFakeToken.isNullOrEmpty()   //TODO for testing purpose

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override suspend fun getToken(): String = sharedPreference.getString(KEY_TOKEN, "")

    override suspend fun storeToken(token: String) {
//        sharedPreference.edit().putString(KEY_TOKEN, token).apply()

        //TODO for testing purpose
        delay(Random.nextLong(100))
        temporaryFakeToken = token
    }
}