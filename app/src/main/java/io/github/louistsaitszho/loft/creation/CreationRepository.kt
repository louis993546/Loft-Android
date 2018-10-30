package io.github.louistsaitszho.loft.creation

interface CreationRepository {
    //TODO return type undetermined
    suspend fun createLoftAndUser(loftName: String, yourName: String)
}