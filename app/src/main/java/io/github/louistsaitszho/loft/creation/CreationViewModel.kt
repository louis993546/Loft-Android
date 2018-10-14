package io.github.louistsaitszho.loft.creation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CreationViewModel(private val repository: CreationRepository) : ViewModel() {
    val keyboardUp = MutableLiveData<Boolean>()

    fun createLoft(loftName: String, yourName: String) {
        if (loftName.isBlank()) throw IllegalArgumentException("Loft name cannot be blank")
        if (yourName.isBlank()) throw IllegalArgumentException("Your name cannot be blank")

        keyboardUp.postValue(false)

        repository.createLoftAndUser(loftName, yourName)    //TODO return type not confirmed yet
    }
}