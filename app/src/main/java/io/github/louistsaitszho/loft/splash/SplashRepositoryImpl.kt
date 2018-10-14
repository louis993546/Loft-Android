package io.github.louistsaitszho.loft.splash

import io.github.louistsaitszho.loft.localStorage.SharedPreferenceManager

class SplashRepositoryImpl(
        private val sharedPreference: SharedPreferenceManager
) : SplashRepository {

    override fun isSignedIn() = sharedPreference.isSignedIn()

}