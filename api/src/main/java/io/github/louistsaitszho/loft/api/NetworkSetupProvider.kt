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
package io.github.louistsaitszho.loft.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import io.github.louistsaitszho.loft.api.adapter.UuidAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * TODO not sure if this is entirely necessary
 *
 * This thing encapsulate network setup so that the module provide method looks a bit more readable.
 */
class NetworkSetupProvider {
    companion object {
        internal fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BuildConfig.HOST)
                .client(okHttpClient)
                .validateEagerly(BuildConfig.DEBUG)
                .build()

        /**
         * TODO interceptors, timeouts
         */
        internal fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

        internal fun provideMoshi(): Moshi = Moshi.Builder()
                .add(UuidAdapter())
                //TODO date time
                .build()
    }
}