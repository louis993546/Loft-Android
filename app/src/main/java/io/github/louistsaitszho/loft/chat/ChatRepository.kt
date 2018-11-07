package io.github.louistsaitszho.loft.chat

import io.github.louistsaitszho.loft.common.model.Message

interface ChatRepository {
    //TODO purely temporary
    fun getMockMessages(): List<Message>
}