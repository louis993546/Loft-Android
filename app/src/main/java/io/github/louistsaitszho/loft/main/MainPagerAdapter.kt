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
        const val PAGE_COUNT = 4
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ConstructionFragment()
            1 -> NotesFragment()
            2 -> ConstructionFragment()
            3 -> ConstructionFragment()
            else -> throw IllegalArgumentException("There is only $PAGE_COUNT pages here")
        }
    }

    override fun getCount() = PAGE_COUNT

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.tab_title_chat)
        1 -> context.getString(R.string.tab_title_notes)
        2 -> context.getString(R.string.tab_title_to_do)
        3 -> context.getString(R.string.tab_title_schedule)
        else -> throw IllegalArgumentException("There is only $PAGE_COUNT pages here")
    }
}