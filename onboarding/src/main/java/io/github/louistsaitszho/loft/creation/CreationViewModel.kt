package io.github.louistsaitszho.loft.creation

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
                repository.createLoftAndUser(loftName, yourName)    //TODO return type not confirmed yet
                //TODO trigger view to go to main if it's successful
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
}