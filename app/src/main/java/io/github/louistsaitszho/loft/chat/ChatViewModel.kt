package io.github.louistsaitszho.loft.chat

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import io.github.louistsaitszho.loft.common.model.Message
import io.github.louistsaitszho.loft.common.utils.addItem
import java.util.*

class ChatViewModel : ScopedViewModel() {
    //TODO some kind of reversed paged list: 1 private(MLD), 1 public(LD)
    private val _conversation: MutableLiveData<List<Message>> = MutableLiveData()
    val conversationLiveData: LiveData<List<Message>>
        get() = _conversation

    fun send(text: String) {
        _conversation.addItem(Message(UUID.randomUUID(), text))
    }

    //TODO send image, video, attachment, etc
}