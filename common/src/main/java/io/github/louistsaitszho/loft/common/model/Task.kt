package io.github.louistsaitszho.loft.common.model

import java.util.*

data class Task(
        val id: UUID,
        val progress: Progress,
        val title: String
        //TODO assignment of member
)

enum class Progress {
    NOT_DONE,
    DONE
}