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

import io.github.louistsaitszho.loft.common.model.*

/**
 * TODO all the return type needs to be from .common.model.*
 */
interface LoftApi {
    //1. create loft TODO this might need to take user name + return User as well
    suspend fun createLoft(name: String): Loft

    //2. create join loft request

    //3. post task
    suspend fun createTask(task: String): Task

    //4. post event
    suspend fun createEvent(): Event

    //5. post note
    suspend fun createNote(): Note

    //6. edit task
    suspend fun editTask(): Task

    //7. edit event
    suspend fun editEvent(): Event

    //8. edit note
    suspend fun editNote(): Event

    //9. delete task
    suspend fun deleteTask(task: Task): Successful

    //10. delete event
    suspend fun deleteEvent(event: Event): Successful

    //11. delete note
    suspend fun deleteNote(note: Note): Successful

    //12. get tasks

    //13. get events

    //14. get notes
}