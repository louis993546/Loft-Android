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
package io.github.louistsaitszho.loft.onboarding.creation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * TODO this desperately needs to be split up to VM & UC
 */
class CreationViewModel(private val repository: CreationRepository) : ScopedViewModel() {
    private val _keyboardFocusLiveData = MutableLiveData<KeyboardFocus>()
    val keyboardFocusLiveData: LiveData<KeyboardFocus>
        get() = _keyboardFocusLiveData

    private val _formErrorLiveData = MutableLiveData<CreationFormError>()
    val formErrorLiveData: LiveData<CreationFormError>
        get() = _formErrorLiveData

    private val _nextSceneLiveData = MutableLiveData<NextScene?>()
    val nextSceneLiveData: LiveData<NextScene?>
        get() = _nextSceneLiveData

    /**
     * TODO refactor the first section: it's a bit too confusing
     */
    fun createLoft(loftName: String, yourName: String) {
        var formError: CreationFormError? = null
        var keyboardFocus: KeyboardFocus? = null

        if (loftName.isBlank()) {
            formError = CreationFormError.BLANK_LOFT_NAME
            keyboardFocus = KeyboardFocus.LOFT_NAME
        } else if (yourName.isBlank()) {
            formError = CreationFormError.BLANK_USER_NAME
            keyboardFocus = KeyboardFocus.USER_NAME
        }

        _keyboardFocusLiveData.postValue(keyboardFocus)
        _formErrorLiveData.postValue(formError)

        if (formError == null) {
            launch(Dispatchers.IO) {
                val loftAndUser = repository.createLoftAndUser(loftName, yourName)
                //TODO catch network error and show something to ui
                repository.saveLoftAndUser(loftAndUser.first, loftAndUser.second)
                _nextSceneLiveData.postValue(NextScene.MAIN)
            }
        }
    }

    enum class CreationFormError {
        BLANK_LOFT_NAME,
        BLANK_USER_NAME
    }

    enum class KeyboardFocus {
        LOFT_NAME,
        USER_NAME
    }

    enum class NextScene {
        MAIN
    }
}