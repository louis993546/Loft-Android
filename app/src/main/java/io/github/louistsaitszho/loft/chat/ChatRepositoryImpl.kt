package io.github.louistsaitszho.loft.chat

import io.github.louistsaitszho.loft.common.model.Message
import java.util.*

class ChatRepositoryImpl : ChatRepository {
    //TODO it needs some kind of internal queue for outgoing message?

    override suspend fun getMessagesAfter(cursor: UUID): List<Message> {
        return emptyList()
    }

    override suspend fun getMessagesBefore(cursor: UUID): List<Message> {
        return emptyList()
    }
}