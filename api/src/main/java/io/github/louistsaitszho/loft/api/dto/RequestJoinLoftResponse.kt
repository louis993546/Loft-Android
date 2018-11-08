package io.github.louistsaitszho.loft.api.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestJoinLoftResponse(val message: String)
