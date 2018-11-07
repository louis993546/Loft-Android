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
        val context: Context,
        //TODO make it public var or something to allow runtime re-ordering
        private val pageOrder: List<Page> = listOf(Page.CHAT, Page.NOTES, Page.TO_DO, Page.SCHEDULE)
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = when (pageOrder[position]) {
        Page.CHAT -> ConstructionFragment()
        Page.NOTES -> NotesFragment()
        Page.TO_DO -> ConstructionFragment()
        Page.SCHEDULE -> ConstructionFragment()
    }

    override fun getCount() = Page.values().size

    override fun getPageTitle(position: Int): CharSequence? = when (pageOrder[position]) {
        Page.CHAT -> context.getString(R.string.tab_title_chat)
        Page.NOTES -> context.getString(R.string.tab_title_notes)
        Page.TO_DO -> context.getString(R.string.tab_title_to_do)
        Page.SCHEDULE -> context.getString(R.string.tab_title_schedule)
    }
}

enum class Page {
    CHAT,
    NOTES,
    TO_DO,
    SCHEDULE
}