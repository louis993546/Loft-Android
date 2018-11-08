package io.github.louistsaitszho.loft.chat

import io.github.louistsaitszho.loft.common.model.Message
import java.util.*

interface ChatRepository {
    //TODO need to return cursor right?
    suspend fun getMessagesBefore(cursor: UUID): List<Message>

    //TODO need to return cursor right?
    suspend fun getMessagesAfter(cursor: UUID): List<Message>
}