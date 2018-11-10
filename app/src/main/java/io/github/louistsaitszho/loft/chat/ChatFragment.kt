package io.github.louistsaitszho.loft.chat

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.utils.getInputText
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
        observeVmLiveData()
        setupRecyclerView()
        setupButtonOnClick()
        edit_text_message.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) hideSoftKeyboard()
        }
    }

    private fun observeVmLiveData() {
        vm.messageFieldLiveData.observe(this, Observer { edit_text_message.setText(it) })
    }

    private fun setupRecyclerView() {
        recycler_view_chat.adapter = chatPagedAdapter
        recycler_view_chat.layoutManager = layoutManager
    }

    private fun setupButtonOnClick() {
        image_button_add.setOnClickListener { openMediaPickerDialog() }
        image_button_send.setOnClickListener { vm.send(edit_text_message.getInputText()) }
    }

    private fun openMediaPickerDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireActivity())
        bottomSheetDialog.setContentView(requireActivity().layoutInflater.inflate(
                R.layout.bottom_sheet_dialog_chat_add_media,
                null
        ))
        bottomSheetDialog.findViewById<ImageButton>(R.id.image_button_take_picture)?.setOnClickListener {
            bottomSheetDialog.dismiss()
            //TODO open camera intent
        }
        bottomSheetDialog.findViewById<ImageButton>(R.id.image_button_add_image_from_gallery)?.setOnClickListener {
            bottomSheetDialog.dismiss()
            //TODO open gallery intent
        }
        bottomSheetDialog.show()
    }

}