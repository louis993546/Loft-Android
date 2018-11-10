package io.github.louistsaitszho.loft.onboarding.creation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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