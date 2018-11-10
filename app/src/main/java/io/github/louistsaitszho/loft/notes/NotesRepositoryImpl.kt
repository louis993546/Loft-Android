package io.github.louistsaitszho.loft.notes

import android.arch.paging.PagedList
import io.github.louistsaitszho.loft.api.LoftApi
import io.github.louistsaitszho.loft.common.model.Note

class NotesRepositoryImpl(val api: LoftApi) : NotesRepository {
    override suspend fun createNote(content: String): Note {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNotesInPages(): PagedList<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}