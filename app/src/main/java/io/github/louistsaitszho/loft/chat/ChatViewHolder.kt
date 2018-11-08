package io.github.louistsaitszho.loft.chat

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.louistsaitszho.loft.common.model.Message
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_chat.*

class ChatViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(message: Message) {
        text_view_message.text = message.message
        text_view_sender_name.text = message.sender.name
    }
}