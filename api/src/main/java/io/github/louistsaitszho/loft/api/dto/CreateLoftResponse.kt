package io.github.louistsaitszho.loft.api.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class CreateLoftResponse(
        val loftName: String,
        val user_name: String
)