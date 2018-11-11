package io.github.louistsaitszho.loft.api.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class RequestJoinLoftResponse(val message: String)
