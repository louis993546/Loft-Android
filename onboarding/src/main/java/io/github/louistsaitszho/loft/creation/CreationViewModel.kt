package io.github.louistsaitszho.loft.creation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreationViewModel(private val repository: CreationRepository) : ScopedViewModel() {
    //TODO change it to keyboard up + which editText should get focus
    private val _keyboardUp = MutableLiveData<Boolean>()
    val keyboardUp: LiveData<Boolean>
        get() = _keyboardUp

    private val _formError = MutableLiveData<CreationFormError>()
    val formError: LiveData<CreationFormError>
        get() = _formError

    fun createLoft(loftName: String, yourName: String) {
        var hasError = false
        if (loftName.isBlank()) {
            _formError.postValue(CreationFormError.BLANK_LOFT_NAME)
            hasError = true
        }
        if (yourName.isBlank()) {
            _formError.postValue(CreationFormError.BLANK_USER_NAME)
            hasError = true
        }

        if (!hasError) {
            _formError.postValue(null)
            _keyboardUp.postValue(false)

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
}