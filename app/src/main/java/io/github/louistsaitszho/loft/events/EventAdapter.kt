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

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Event

class EventAdapter(
        private val onEventClick: (Event) -> Unit
) : PagedListAdapter<Event, EventViewHolder>(EventDiffUtilItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EventViewHolder(
            LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_event,
                    parent,
                    false
            )
    )

    override fun onBindViewHolder(viewHolder: EventViewHolder, position: Int) {
        getItem(position)?.run { viewHolder.bind(this, onEventClick) }
    }

    companion object {
        private val EventDiffUtilItemCallback = object : DiffUtil.ItemCallback<Event>() {
            override fun areItemsTheSame(oldItem: Event, newItem: Event) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Event, newItem: Event) = oldItem == newItem
        }
    }
}