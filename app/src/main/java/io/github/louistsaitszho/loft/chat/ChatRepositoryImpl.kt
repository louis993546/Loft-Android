package io.github.louistsaitszho.loft.chat

import io.github.louistsaitszho.loft.common.model.Message

class ChatRepositoryImpl : ChatRepository {
    override fun getMockMessages(): List<Message> {
        return listOf(
                Message("1"),
                Message("2"),
                Message("3"),
                Message("4"),
                Message("5")
        )
    }
}