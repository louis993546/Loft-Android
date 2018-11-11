/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
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