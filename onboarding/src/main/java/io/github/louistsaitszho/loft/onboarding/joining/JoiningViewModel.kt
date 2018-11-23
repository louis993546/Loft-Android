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
package io.github.louistsaitszho.loft.onboarding.joining

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class JoiningViewModel : ScopedViewModel() {
    private val _viewState = MutableLiveData<ViewState>()
    val viewStateLiveData: LiveData<ViewState>
        get() = _viewState

    /**
     * Call this message to fire a request to join a loft
     */
    fun sendJoinLoftRequest(loftId: String, yourName: String, message: String) {
        val invalidFields = mutableListOf<InputField>()

        if (loftId.isEmpty()) {
            invalidFields.add(InputField.LOFT_ID)
        }

        if (yourName.isEmpty()) {
            invalidFields.add(InputField.USER_NAME)
        }

        if (invalidFields.isNotEmpty()) {
            _viewState.postValue(ViewState.InvalidInput(invalidFields))
        } else {
            launch(Dispatchers.IO) {
                delay(Random.nextLong(1000))    //TODO mock api delay
                _viewState.postValue(ViewState.RequestSentSuccess)
            }
        }
    }

    sealed class ViewState {
        class InvalidInput(val invalidFields: List<InputField>) : ViewState()
        object RequestSentSuccess : ViewState()
        class RequestSentFailure(val cause: Throwable) : ViewState()
    }

    enum class InputField {
        LOFT_ID,
        USER_NAME,
        MESSAGE
    }
}