package io.github.louistsaitszho.loft.splash

interface SplashRepository {
    suspend fun isSignedIn(): Boolean
}