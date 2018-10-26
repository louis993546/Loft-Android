package io.github.louistsaitszho.loft.notes

import io.github.louistasitszho.loft.common.network.API

class NotesRepositoryImpl(val api: API) : NotesRepository {
    override suspend fun createNote(content: String): Note {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}