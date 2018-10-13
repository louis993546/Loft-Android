package io.github.louistsaitszho.loft.notes

interface NotesRepository {
    suspend fun createNote(content: String): Note
}