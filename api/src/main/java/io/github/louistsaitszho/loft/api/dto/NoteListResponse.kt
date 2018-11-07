package io.github.louistsaitszho.loft.api.dto

//TODO page number vs offset + limit vs cursor
data class NoteListResponse(val noteList: List<NoteResponse>)
