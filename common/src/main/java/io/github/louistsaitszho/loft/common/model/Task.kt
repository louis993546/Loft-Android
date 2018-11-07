package io.github.louistsaitszho.loft.common.model

data class Task(
        val progress: Progress,
        val title: String
        //TODO assignment of member
)

enum class Progress {
    NOT_DONE,
    DONE
}