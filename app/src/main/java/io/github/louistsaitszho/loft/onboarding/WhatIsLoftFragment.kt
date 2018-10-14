package io.github.louistsaitszho.loft.onboarding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import io.github.louistsaitszho.loft.R
import kotlinx.android.synthetic.main.fragment_what_is_loft.*

class WhatIsLoftFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_what_is_loft, container, false)
    }

    override fun onResume() {
        super.onResume()
        fab_next.setOnClickListener {
            findNavController().navigate(R.id.action_whatIsLoftFragment_to_enterLoftFragment)
        }
    }
}