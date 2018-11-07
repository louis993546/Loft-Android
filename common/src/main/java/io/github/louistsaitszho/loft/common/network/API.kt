package io.github.louistsaitszho.loft.common.network

import io.github.louistsaitszho.loft.common.network.dto.CreateLoftResponse
import io.github.louistsaitszho.loft.common.network.dto.NoteListResponse
import io.github.louistsaitszho.loft.common.network.dto.RequestJoinLoftResponse

interface API {
    suspend fun createLoft(loftName: String, userName: String): CreateLoftResponse

    suspend fun requestJoinLoft(loftCode: String, userName: String): RequestJoinLoftResponse

    suspend fun getNotes(): NoteListResponse

//    suspend fun createNote(newNote: NewNoteRequest): NewNoteResponse
}