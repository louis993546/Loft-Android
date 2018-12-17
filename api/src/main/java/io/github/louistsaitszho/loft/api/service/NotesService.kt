package io.github.louistsaitszho.loft.api.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface NotesService {
    @POST("/notes")
    fun postNotes()

    @GET("/notes")
    fun getNotes()

    @PATCH("/notes")
    fun patchNotes()

    @DELETE("/notes")
    fun deleteNotes()
}