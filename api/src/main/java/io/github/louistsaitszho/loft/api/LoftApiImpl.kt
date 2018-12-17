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
package io.github.louistsaitszho.loft.api

import io.github.louistsaitszho.loft.common.keyValueStore.KeyValueStore
import io.github.louistsaitszho.loft.common.model.*
import retrofit2.Retrofit

/**
 * TODO instead of taking retrofit, take retrofit service interface
 */
class LoftApiImpl(val retrofit: Retrofit, val keyValueStore: KeyValueStore) : LoftApi {
    private val loftService: LoftService = retrofit.create(LoftService::class.java)

    override suspend fun createLoft(name: String): Loft {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun createTask(task: String): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun createEvent(): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun createNote(): Note {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editTask(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editEvent(): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editNote(): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteTask(task: Task): Successful {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteEvent(event: Event): Successful {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteNote(note: Note): Successful {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}