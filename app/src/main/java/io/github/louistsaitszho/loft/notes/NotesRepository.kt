package io.github.louistsaitszho.loft.notes

import android.arch.paging.PagedList
import io.github.louistsaitszho.loft.common.model.Note

interface NotesRepository {
    suspend fun createNote(content: String): Note

    fun getNotesInPages(): PagedList<Note>
}