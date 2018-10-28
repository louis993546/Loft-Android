package io.github.louistsaitszho.loft.splash

import io.github.louistasitszho.loft.common.keyValueStore.KeyValueStore

class SplashRepositoryImpl(
        private val sharedPreference: KeyValueStore
) : SplashRepository {

    override suspend fun isSignedIn() = sharedPreference.isSignedIn()

}