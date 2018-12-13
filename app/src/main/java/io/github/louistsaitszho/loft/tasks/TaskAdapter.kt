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

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Task

/**
 * TODO this one is the ultimate one with paging
 */
//class TaskAdapter : PagedListAdapter<Task, TaskViewHolder>(taskDiffCallback) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//            TaskViewHolder(LayoutInflater.from(parent.context).inflate(
//                    R.layout.viewholder_task,
//                    parent,
//                    false
//            ))
//
//    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        getItem(position)?.run { holder.bind(this) }
//    }
//
//    companion object {
//        private val taskDiffCallback = object : DiffUtil.ItemCallback<Task>() {
//            override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id
//
//            override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem
//        }
//    }
//}

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private var tasks = emptyList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_task,
                    parent,
                    false
            )
    )

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(viewHolder: TaskViewHolder, position: Int) {
        viewHolder.bind(tasks[position])
    }

    fun updateTaskList(newTasks: List<Task>) {
        val diffResult = DiffUtil.calculateDiff(TaskDiffUtilCallback(tasks, newTasks))
        tasks = newTasks
        diffResult.dispatchUpdatesTo(this)
    }
}

class TaskDiffUtilCallback(
        private val oldTasks: List<Task>,
        private val newTasks: List<Task>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldTasks.size

    override fun getNewListSize() = newTasks.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldTasks[oldItemPosition].id == newTasks[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldTasks[oldItemPosition] == newTasks[newItemPosition]

}