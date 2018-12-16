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
package io.github.louistsaitszho.loft.events

import io.github.louistsaitszho.loft.common.model.Event
import io.github.louistsaitszho.loft.common.model.Successful
import org.threeten.bp.ZonedDateTime

interface EventsRepository {
    //TODO this probably won't exist in the final 1: no pagination support
    suspend fun getEvents(): List<Event>

    suspend fun createEvent(
            startTime: ZonedDateTime,
            endTime: ZonedDateTime,
            title: String
    ): Event

    suspend fun updateEvent(
            oldEvent: Event,
            newStartTime: ZonedDateTime?,
            newEndTime: ZonedDateTime?,
            newTitle: String?
    ): Event

    suspend fun deleteEvent(event: Event): Successful
}