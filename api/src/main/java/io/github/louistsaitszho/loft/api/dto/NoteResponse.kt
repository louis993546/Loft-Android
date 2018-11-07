package io.github.louistsaitszho.loft.api.dto

import java.util.*

data class NoteResponse(val id: UUID, val note: String, val format: TextFormat)

enum class TextFormat {
    COMMON_MARK,
    UNKNOWN         //something goes wrong with LoftApi, new format, etc
}