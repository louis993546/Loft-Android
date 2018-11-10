package io.github.louistsaitszho.loft.tasks

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.louistsaitszho.loft.common.model.Task
import kotlinx.android.extensions.LayoutContainer

class TaskViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(task: Task) {

    }
}