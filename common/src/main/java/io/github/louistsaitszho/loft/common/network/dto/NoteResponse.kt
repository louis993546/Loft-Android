package io.github.louistsaitszho.loft.common.network.dto

import java.util.*

data class NoteResponse(val id: UUID, val note: String, val format: TextFormat)

enum class TextFormat {
    COMMON_MARK,
    UNKNOWN         //something goes wrong with API, new format, etc
}