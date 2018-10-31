package io.github.louistsaitszho.loft.creation

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistasitszho.loft.common.utils.getInputText
import io.github.louistasitszho.loft.common.utils.hideSoftKeyboard
import io.github.louistasitszho.loft.common.utils.showSoftKeyboard
import io.github.louistsaitszho.loft.R
import kotlinx.android.synthetic.main.fragment_creation.*
import timber.log.Timber
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class CreationFragment : Fragment() {

    private val viewModel: CreationViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_creation, container, false)
        subscribeToAllLiveData()
        return view
    }

    private fun subscribeToAllLiveData() {
        //TODO use view lifecycle owner when I got androidx
        viewModel.keyboardUp.observe(this, Observer { up ->
            when (up) {
                true -> showSoftKeyboard()
                false -> hideSoftKeyboard()
            }
        })
        viewModel.formError.observe(this, Observer {
            when (it) {
                CreationViewModel.CreationFormError.BLANK_LOFT_NAME ->
                    edit_text_loft_name.error = "Loft name cannot be blank"
                CreationViewModel.CreationFormError.BLANK_USER_NAME ->
                    edit_text_your_name.error = "Your name cannot be blank"
                null -> {
                    edit_text_loft_name.error = null
                    edit_text_your_name.error = null
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        fab_create_loft_confirm.setOnClickListener {
            Timber.d("fab create loft clicked")
            viewModel.createLoft(
                    loftName = edit_text_loft_name.getInputText(),
                    yourName = edit_text_your_name.getInputText()
            )
        }
        edit_text_your_name.setOnEditorActionListener { _, actionId, event ->
            Timber.d("your name action triggered: $actionId, $event")
            true
        }
    }
}
