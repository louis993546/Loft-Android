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

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import io.github.louistsaitszho.loft.common.model.Task
import kotlinx.coroutines.launch

/**
 * TODO list
 *
 * -
 */
class TasksViewModel(private val repository: TasksRepository) : ScopedViewModel() {
    private val _tasksListLiveData = MutableLiveData<List<Task>>()
    val tasksListLiveData: LiveData<List<Task>>
        get() = _tasksListLiveData

    fun triggerTaskListFetching() {
        launch {
            val taskList = repository.getTasksTemp()
            _tasksListLiveData.postValue(taskList)
        }
    }
}