package io.github.louistsaitszho.loft.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.ScopedFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : ScopedFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tab_layout.setupWithViewPager(view_pager)
        view_pager.adapter = MainPagerAdapter(requireFragmentManager(), requireContext())
    }
}