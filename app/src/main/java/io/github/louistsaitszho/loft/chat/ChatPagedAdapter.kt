package io.github.louistsaitszho.loft.chat

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Message

class ChatPagedAdapter : PagedListAdapter<Message, ChatViewHolder>(ChatDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ChatViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_chat,
                    parent,
                    false
            ))

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        getItem(position)?.run { holder.bind(this) }
    }

    companion object {
        private val ChatDiffCallback = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(oldItem: Message?, newItem: Message?) =
                    oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: Message?, newItem: Message?) =
                    oldItem == newItem

        }
    }
}