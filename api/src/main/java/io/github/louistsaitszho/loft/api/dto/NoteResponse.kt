package io.github.louistsaitszho.loft.api.dto

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
internal data class NoteResponse(val id: UUID, val note: String, val format: TextFormat)

internal enum class TextFormat {
    COMMON_MARK,
    UNKNOWN         //something goes wrong with LoftApi, new format, etc
}