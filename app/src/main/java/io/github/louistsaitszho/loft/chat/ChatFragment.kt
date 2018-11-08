package io.github.louistsaitszho.loft.chat

import android.arch.paging.PagedListAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Message
import io.github.louistsaitszho.loft.common.utils.reset
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.viewholder_chat.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * TODO use DiffUtil
 * TODO use Paging
 */
class ChatFragment : Fragment() {
    private val vm: ChatViewModel by viewModel()
    private val chatPagedAdapter: ChatPagedAdapter by lazy { ChatPagedAdapter() }
    private val layoutManager: LinearLayoutManager by lazy { LinearLayoutManager(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_chat.adapter = chatPagedAdapter
        recycler_view_chat.layoutManager = layoutManager
    }
}

class ChatViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(message: Message) {
        text_view_message.text = message.message
        text_view_sender_name.text = message.sender.name
    }
}

@Deprecated(message = "Use the PagedAdapter")
class ChatAdapter : RecyclerView.Adapter<ChatViewHolder>() {
    private val messageList: MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ChatViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_chat,
                    parent,
                    false
            ))

    override fun getItemCount() = messageList.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    fun setMessages(messages: List<Message>) {
        messageList.reset(messages)
        notifyDataSetChanged()
    }
}

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