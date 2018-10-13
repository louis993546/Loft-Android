package io.github.louistsaitszho.loft.notes

import java.util.*

//TODO content will becomes not just plain text at some point I guess
data class Note(
        val id: UUID,
        val content: String
)