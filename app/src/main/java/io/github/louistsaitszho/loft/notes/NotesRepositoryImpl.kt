package io.github.louistsaitszho.loft.notes

import io.github.louistsaitszho.loft.api.LoftApi

class NotesRepositoryImpl(val api: LoftApi) : NotesRepository {
    override suspend fun createNote(content: String): Note {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}