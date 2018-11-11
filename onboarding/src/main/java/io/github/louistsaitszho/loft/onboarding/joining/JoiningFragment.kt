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
package io.github.louistsaitszho.loft.onboarding.joining

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import io.github.louistsaitszho.loft.common.navigationDelegate.NavigationFragment
import io.github.louistsaitszho.loft.common.navigationDelegate.Transition
import io.github.louistsaitszho.loft.common.utils.getInputText
import io.github.louistsaitszho.loft.common.utils.showSoftKeyboardAndFocus
import io.github.louistsaitszho.loft.onboarding.R
import io.github.louistsaitszho.loft.onboarding.joining.JoiningViewModel.InputField
import kotlinx.android.synthetic.main.fragment_joining.*
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class JoiningFragment : NavigationFragment() {

    private val viewModel: JoiningViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_joining, container, false)
        observeViewState()
        return view
    }

    private fun observeViewState() {
        viewModel.viewStateLiveData.observe(this, Observer { viewState ->
            when (viewState) {
                is JoiningViewModel.ViewState.InvalidInput ->
                    highlightInvalidInputFields(viewState.invalidFields)
                is JoiningViewModel.ViewState.RequestSent ->
                    navigationDelegate?.navigate(Transition.Joining2WaitForConfirmation())
            }
        })
    }

    private fun highlightInvalidInputFields(invalidFields: List<JoiningViewModel.InputField>) {
        markErrorEditTextFields(invalidFields)
        focusOnFirstErrorFieldAndShowKeyboard(invalidFields)
    }

    private fun markErrorEditTextFields(invalidFields: List<JoiningViewModel.InputField>) {
        invalidFields.forEach { field ->
            when (field) {
                InputField.LOFT_ID -> edit_text_loft_id.error = "Loft id cannot be blank"
                InputField.USER_NAME -> edit_text_your_name.error = "Your name cannot be blank"
                InputField.MESSAGE -> TODO("I don't have a use for this")
            }
        }
    }

    private fun focusOnFirstErrorFieldAndShowKeyboard(invalidFields: List<InputField>) {
        val firstEditText = pickFirstEditText(
                edit_text_loft_id to invalidFields.contains(InputField.LOFT_ID),
                edit_text_your_name to invalidFields.contains(InputField.USER_NAME)
        )
        firstEditText?.showSoftKeyboardAndFocus()
    }

    /**
     * Sequentially find the first element that has it's value == true, null if none has true
     *
     * TODO generalize it
     */
    private fun pickFirstEditText(vararg editTextHasErrorPair: Pair<EditText, Boolean>): EditText? {
        for (it in editTextHasErrorPair) {
            if (it.second) return it.first
        }
        return null
    }

    override fun onStart() {
        super.onStart()
        fab_join_loft_confirm.setOnClickListener {
            viewModel.sendJoinLoftRequest(
                    edit_text_loft_id.getInputText(),
                    edit_text_your_name.getInputText(),
                    edit_text_request_join_message.getInputText()
            )
        }
    }
}
