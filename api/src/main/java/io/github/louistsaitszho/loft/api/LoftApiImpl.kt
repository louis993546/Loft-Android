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