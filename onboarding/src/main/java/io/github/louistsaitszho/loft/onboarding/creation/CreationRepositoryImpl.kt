package io.github.louistsaitszho.loft.onboarding.creation

import io.github.louistsaitszho.loft.api.LoftApi
import io.github.louistsaitszho.loft.common.keyValueStore.KeyValueStore
import io.github.louistsaitszho.loft.common.model.Loft
import io.github.louistsaitszho.loft.common.model.Member
import io.github.louistsaitszho.loft.common.utils.nextString
import kotlinx.coroutines.delay
import java.util.*
import kotlin.random.Random

class CreationRepositoryImpl(
        val api: LoftApi,
        private val keyValueStore: KeyValueStore
) : CreationRepository {
    override suspend fun createLoftAndUser(loftName: String, yourName: String): Pair<Loft, Member> {
        //TODO for testing purpose
        //TODO mock network error
        delay(Random.nextLong(1000))
        return Loft(loftName) to Member(UUID.randomUUID(), yourName, Random.nextString(128))
    }

    override suspend fun saveLoftAndUser(loft: Loft, user: Member) {
        if (user.token.isNullOrEmpty()) {
            throw IllegalArgumentException("It does not seem like a valid user")
        } else {
            keyValueStore.storeToken(user.token!!)
            //TODO store loft info, but where? db or keyValue
        }
    }
}