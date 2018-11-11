/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
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