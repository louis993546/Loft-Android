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

import io.github.louistsaitszho.loft.common.model.Loft
import io.github.louistsaitszho.loft.common.model.Member

interface CreationRepository {
    suspend fun createLoftAndUser(loftName: String, yourName: String): Pair<Loft, Member>

    suspend fun saveLoftAndUser(loft: Loft, user: Member)
}