package io.github.louistsaitszho.loft.api

import io.github.louistsaitszho.loft.api.dto.CreateLoftResponse
import io.github.louistsaitszho.loft.api.dto.NoteListResponse
import io.github.louistsaitszho.loft.api.dto.RequestJoinLoftResponse

interface LoftApi {
    suspend fun createLoft(loftName: String, userName: String): CreateLoftResponse

    suspend fun requestJoinLoft(loftCode: String, userName: String): RequestJoinLoftResponse

    suspend fun getNotes(): NoteListResponse

//    suspend fun createNote(newNote: NewNoteRequest): NewNoteResponse
}