package io.github.louistsaitszho.loft.common.model

data class Note(
        val content: String,
        val format: TextFormat
)

enum class TextFormat {
    COMMON_MARK
}