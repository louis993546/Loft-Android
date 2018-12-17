package io.github.louistsaitszho.loft.api.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH

interface MembersService {
    //TODO Do I need POST?

    @GET("/members")
    fun getMembers()

    @PATCH("/members")
    fun patchMembers()

    @DELETE("/members")
    fun deleteMembers()
}