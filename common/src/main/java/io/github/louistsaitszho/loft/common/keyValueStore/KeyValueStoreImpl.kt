/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.louistsaitszho.loft.common.keyValueStore

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Implementation of Key-Value store, powered by SharedPreference
 */
class KeyValueStoreImpl(private val context: Context) : KeyValueStore {
    private var temporaryFakeToken: String? = "asdfdsafsadf"

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