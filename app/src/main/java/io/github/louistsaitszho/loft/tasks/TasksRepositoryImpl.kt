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
import kotlinx.coroutines.delay
import java.util.*

class TasksRepositoryImpl : TasksRepository {
    override suspend fun getTasksTemp(): List<Task> {
        delay(1000)
        return listOf(
                Task(UUID.randomUUID(), random(), "task 1"),
                Task(UUID.randomUUID(), random(), "task 2"),
                Task(UUID.randomUUID(), random(), "task 3"),
                Task(UUID.randomUUID(), random(), "task 4"),
                Task(UUID.randomUUID(), random(), "task 5"),
                Task(UUID.randomUUID(), random(), "task 6")
        )
    }

    override suspend fun createTask(newTask: Task): Successful {
        delay(500)
        return true
    }

    override suspend fun updateTask(oldTask: Task, newTask: Task): Successful {
        //find difference between the 2 tasks
        //call the api accordingly

        delay(1000)
        return true
    }

    override suspend fun deleteTask(task: Task): Successful {
        delay(500)
        return true
    }
}

/**
 * Pick a random value from a enum class
 *
 * TODO move this util to somewhere else
 */
inline fun <reified T : Enum<T>> random(): T = enumValues<T>().random()