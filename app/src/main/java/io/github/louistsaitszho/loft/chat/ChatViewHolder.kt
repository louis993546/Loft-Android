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