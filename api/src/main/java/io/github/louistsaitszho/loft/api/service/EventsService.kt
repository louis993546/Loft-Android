package io.github.louistsaitszho.loft.api.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface EventsService {
    @POST("/events")
    fun postEvents()

    @GET("/events")
    fun getEvents()

    @PATCH("/events")
    fun patchEvents()

    @DELETE("/events")
    fun deleteEvents()
}