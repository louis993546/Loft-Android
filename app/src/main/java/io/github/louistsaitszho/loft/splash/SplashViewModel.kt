package io.github.louistsaitszho.loft.splash

import android.arch.lifecycle.ViewModel

class SplashViewModel(private val repository: SplashRepository) : ViewModel() {
    suspend fun isSignedIn(): Boolean = repository.isSignedIn()
}