package io.github.louistsaitszho.loft.common.network

interface API {
    suspend fun createLoft(loftName: String, userName: String)

    suspend fun requestJoinLoft(loftCode: String, userName: String)
}