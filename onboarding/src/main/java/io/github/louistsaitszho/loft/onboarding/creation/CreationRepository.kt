package io.github.louistsaitszho.loft.onboarding.creation

import io.github.louistsaitszho.loft.common.model.Loft
import io.github.louistsaitszho.loft.common.model.Member

interface CreationRepository {
    suspend fun createLoftAndUser(loftName: String, yourName: String): Pair<Loft, Member>

    suspend fun saveLoftAndUser(loft: Loft, user: Member)
}