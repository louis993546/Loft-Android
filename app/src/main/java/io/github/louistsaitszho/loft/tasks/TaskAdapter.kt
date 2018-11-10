package io.github.louistsaitszho.loft.tasks

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Task

class TaskAdapter : PagedListAdapter<Task, TaskViewHolder>(taskDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            TaskViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_task,
                    parent,
                    false
            ))

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        getItem(position)?.run { holder.bind(this) }
    }

    companion object {
        private val taskDiffCallback = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task?, newItem: Task?) =
                    oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: Task?, newItem: Task?) =
                    oldItem == newItem

        }
    }
}