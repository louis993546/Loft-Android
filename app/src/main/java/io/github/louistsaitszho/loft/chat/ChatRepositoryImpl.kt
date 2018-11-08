package io.github.louistsaitszho.loft.chat

import io.github.louistsaitszho.loft.common.model.Message
import java.util.*

class ChatRepositoryImpl : ChatRepository {
    override fun getMockMessages(): List<Message> {
        return listOf(
                Message(UUID.randomUUID(), "1"),
                Message(UUID.randomUUID(), "2"),
                Message(UUID.randomUUID(), "3"),
                Message(UUID.randomUUID(), "4")
        )
    }
}