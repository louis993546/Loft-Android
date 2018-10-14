package io.github.louistsaitszho.loft.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.notes.NotesFragment
import io.github.louistsaitszho.loft.temporary.ConstructionFragment

class MainPagerAdapter(
        fragmentManager: FragmentManager,
        val context: Context
) : FragmentPagerAdapter(fragmentManager) {
    companion object {
        const val PAGE_COUNT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ConstructionFragment()
            1 -> NotesFragment()
            else -> throw IllegalArgumentException("Do not have any page >= $PAGE_COUNT")
        }
    }

    override fun getCount() = PAGE_COUNT

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.tab_title_chat)
        1 -> context.getString(R.string.tab_title_notes)
        else -> throw IllegalArgumentException("Do not have any page >= $PAGE_COUNT")
    }
}