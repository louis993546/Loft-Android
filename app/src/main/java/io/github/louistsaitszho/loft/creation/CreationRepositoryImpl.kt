package io.github.louistsaitszho.loft.creation

import io.github.louistsaitszho.loft.api.LoftApi

class CreationRepositoryImpl(val api: LoftApi) : CreationRepository {
    override suspend fun createLoftAndUser(loftName: String, yourName: String) {

    }
}