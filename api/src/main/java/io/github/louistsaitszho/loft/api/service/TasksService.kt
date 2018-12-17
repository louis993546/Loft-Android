package io.github.louistsaitszho.loft.api.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface TasksService {
    @POST("/tasks")
    fun postTasks()

    @GET("/tasks")
    fun getTasks()

    @PATCH("/tasks")
    fun patchTasks()

    @DELETE("/tasks")
    fun deleteTasks()
}