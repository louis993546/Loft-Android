package io.github.louistsaitszho.loft.common.model

import java.util.*

data class Note(
        val id: UUID,
        val content: String,
        val format: TextFormat
)

enum class TextFormat {
    COMMON_MARK
}