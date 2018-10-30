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

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ConstructionFragment()
            1 -> NotesFragment()
            2 -> ConstructionFragment()
            3 -> ConstructionFragment()
            else -> throw IllegalArgumentException("There is only ${Pages.values().size} pages here")
        }
    }

    override fun getCount() = Pages.values().size

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.tab_title_chat)
        1 -> context.getString(R.string.tab_title_notes)
        2 -> context.getString(R.string.tab_title_to_do)
        3 -> context.getString(R.string.tab_title_schedule)
        else -> throw IllegalArgumentException("There is only ${Pages.values().size} pages here")
    }
}

//TODO use this to add the ability to reorder stuff
enum class Pages(val defaultPosition: Int, val titleStringRes: Int) {
    CHAT(0, R.string.tab_title_chat),
    NOTES(1, R.string.tab_title_notes),
    TO_DO(2, R.string.tab_title_to_do),
    SCHEDULE(3, R.string.tab_title_schedule)
}