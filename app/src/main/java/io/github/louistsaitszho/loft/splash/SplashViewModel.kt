package io.github.louistsaitszho.loft.splash

import io.github.louistsaitszho.loft.ScopedViewModel

class SplashViewModel(private val repository: SplashRepository) : ScopedViewModel() {
    fun isSignedIn(): Boolean = repository.isSignedIn()
}