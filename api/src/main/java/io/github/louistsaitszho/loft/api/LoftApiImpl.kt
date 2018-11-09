package io.github.louistsaitszho.loft.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.github.louistsaitszho.loft.api.dto.CreateLoftResponse
import io.github.louistsaitszho.loft.api.dto.NoteListResponse
import io.github.louistsaitszho.loft.api.dto.RequestJoinLoftResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class LoftApiImpl : LoftApi {
    private val api: Retrofit by lazy {
        Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("")
                .client(okhttp)
                .build()
    }
    private val okhttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
                //TODO read write connection timeout
                .build()
    }

    override suspend fun createLoft(loftName: String, userName: String): CreateLoftResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun requestJoinLoft(loftCode: String, userName: String): RequestJoinLoftResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getNotes(): NoteListResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}