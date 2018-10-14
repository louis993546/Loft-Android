package io.github.louistsaitszho.loft.onboarding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.github.louistsaitszho.loft.R
import kotlinx.android.synthetic.main.fragment_enter_loft.*

class EnterLoftFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_loft, container, false)
    }

    override fun onStart() {
        super.onStart()
        fab_create_loft.setOnClickListener {
            findNavController().navigate(R.id.action_enterLoftFragment_to_creationFragment)
        }
        fab_join_loft.setOnClickListener {
            findNavController().navigate(R.id.action_enterLoftFragment_to_joiningFragment)
        }
    }
}