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
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class LoftApiImpl : LoftApi {
    private val api: Retrofit by lazy {
        Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .addConverterFactory()
                .baseUrl(BuildConfig.HOST)
                .client(okhttp)
                .build()
    }
    private val okhttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
                //TODO read write connection timeout
//                .addInterceptor { chain ->
//                    Timber.tag("NormalInterceptor").i(chain.request().url().toString())
//                    chain.proceed(chain.request())
//                }
//                .addNetworkInterceptor { chain ->
//                    Timber.tag("NetworkInterceptor").i(chain.request().url().toString())
//                    chain.proceed(chain.request())
//                }
                .build()
    }
}