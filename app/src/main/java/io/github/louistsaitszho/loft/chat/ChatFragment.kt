package io.github.louistsaitszho.loft.chat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.utils.hideSoftKeyboard
import kotlinx.android.synthetic.main.fragment_chat.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * TODO use DiffUtil
 */
class ChatFragment : Fragment() {
    private val vm: ChatViewModel by viewModel()
    private val chatPagedAdapter: ChatPagedAdapter by lazy { ChatPagedAdapter() }
    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(requireContext()).apply {
            stackFromEnd = true     //bottom to top
//            reverseLayout = true    //new at bottom?
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_chat.adapter = chatPagedAdapter
        recycler_view_chat.layoutManager = layoutManager
        edit_text_message.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) hideSoftKeyboard()
        }
        image_button_send.setOnClickListener {

        }
    }
}