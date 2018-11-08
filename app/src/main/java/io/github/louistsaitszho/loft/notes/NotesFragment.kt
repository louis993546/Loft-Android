package io.github.louistsaitszho.loft.notes

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class NotesFragment : Fragment() {

    private val viewModel: NotesViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notes, container, false)
        monitorViewState()
        return view
    }

    private fun monitorViewState() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is NoNotes -> {
                }
                is HasNotes -> {
                }
            }
        })
    }
}