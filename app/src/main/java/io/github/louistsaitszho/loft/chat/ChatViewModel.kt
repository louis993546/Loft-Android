package io.github.louistsaitszho.loft.chat

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.content.Intent
import io.github.louistsaitszho.loft.common.ScopedViewModel

//TODO a field in constructor call myself: Member
class ChatViewModel(val repository: ChatRepository) : ScopedViewModel() {
    private val _messageFieldLiveData = MediatorLiveData<String?>()
    val messageFieldLiveData: LiveData<String?>
        get() = _messageFieldLiveData

    //TODO paged list of messages

    //TODO send text, image, video, attachment, etc
    fun send(text: String) {
        if (text.isNotBlank()) {
            //TODO send it to repository
            _messageFieldLiveData.postValue(null)
        }
    }

    fun takePictureFinished(success: Boolean, data: Intent?) {
        if (success) {
            //TODO extract info from data probably
        } else {
            //TODO some error state LD
        }
    }
}