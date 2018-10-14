package io.github.louistsaitszho.loft.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import io.github.louistsaitszho.loft.notes.NotesFragment
import io.github.louistsaitszho.loft.temporary.ConstructionFragment

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ConstructionFragment()
            1 -> NotesFragment()
            else -> throw IllegalArgumentException("Do not have any page >= 2")
        }
    }

    override fun getCount() = 2
}