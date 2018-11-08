package io.github.louistsaitszho.loft.api.dto

import com.squareup.moshi.JsonClass

//TODO cursor
@JsonClass(generateAdapter = true)
data class NoteListResponse(val noteList: List<NoteResponse>)
