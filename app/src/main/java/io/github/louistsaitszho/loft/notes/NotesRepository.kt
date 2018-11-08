package io.github.louistsaitszho.loft.notes

import android.arch.paging.PagedList

interface NotesRepository {
    suspend fun createNote(content: String): Note

    fun getNotesInPages(): PagedList<Note>
}