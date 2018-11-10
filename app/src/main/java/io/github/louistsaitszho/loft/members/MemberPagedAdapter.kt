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