package io.github.louistsaitszho.loft.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private val pagerAdapter: MainPagerAdapter by lazy {
        MainPagerAdapter(requireFragmentManager(), requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tab_layout.setupWithViewPager(view_pager)
        view_pager.adapter = pagerAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        pagerAdapter.delegateOnActivityResult(requestCode, resultCode, data)
    }
}