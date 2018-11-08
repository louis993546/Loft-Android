package io.github.louistsaitszho.loft.chat

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
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
    private val chatAdapter: ChatAdapter by lazy { ChatAdapter() }
    private val layoutManager: LinearLayoutManager by lazy { LinearLayoutManager(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        subscribeToLiveData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_chat.adapter = chatAdapter
        recycler_view_chat.layoutManager = layoutManager
        vm.triggerTempDataFetch()
    }

    private fun subscribeToLiveData() {
        vm.conversationLiveData.observe(this, Observer { messages ->
            messages?.run { chatAdapter.setMessages(this) }
        })
    }
}

class ChatViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(message: Message) {
        text_view_message.text = message.message
    }
}

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