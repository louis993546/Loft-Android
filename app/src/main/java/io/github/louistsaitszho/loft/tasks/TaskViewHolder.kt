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

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.louistsaitszho.loft.common.model.Progress
import io.github.louistsaitszho.loft.common.model.Task
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_task.*

/**
 * TODO
 * - on check click callback -> mark as done/not done
 * - on item click callback -> open edit view
 */
class TaskViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    fun bind(task: Task) {
        text_view_task.text = task.title
        when (task.progress) {
            Progress.NOT_DONE -> check_box_task.isChecked = false
            Progress.DONE -> check_box_task.isChecked = true
        }
    }
}