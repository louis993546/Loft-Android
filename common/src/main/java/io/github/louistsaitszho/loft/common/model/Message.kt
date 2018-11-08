package io.github.louistsaitszho.loft.common.model

import java.util.*

data class Message(
        val id: UUID,
        val message: String,
        val sender: Member
)