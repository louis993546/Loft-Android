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
package io.github.louistsaitszho.loft.members

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Member

class MemberPagedAdapter : PagedListAdapter<Member, MemberViewHolder>(memberDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MemberViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_member,
                    parent,
                    false
            ))

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        getItem(position)?.run { holder.bind(this) }
    }

    companion object {
        private val memberDiffCallback = object : DiffUtil.ItemCallback<Member>() {
            override fun areItemsTheSame(oldItem: Member?, newItem: Member?) =
                    oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: Member?, newItem: Member?) =
                    oldItem == newItem
        }
    }
}