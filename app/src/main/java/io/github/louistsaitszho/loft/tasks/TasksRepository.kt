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
package io.github.louistsaitszho.loft.tasks

import io.github.louistsaitszho.loft.common.model.Task

typealias Successful = Boolean

interface TasksRepository {
    //TODO this will probably not exist in final version (no pagination)
    suspend fun getTasksTemp(): List<Task>

    suspend fun createTask(newTask: Task): Successful

    suspend fun updateTask(oldTask: Task, newTask: Task): Successful

    suspend fun deleteTask(task: Task): Successful
}