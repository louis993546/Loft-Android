package io.github.louistsaitszho.loft.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.chat.ChatFragment
import io.github.louistsaitszho.loft.members.MembersFragment
import io.github.louistsaitszho.loft.more.MoreFragment
import io.github.louistsaitszho.loft.notes.NotesFragment
import io.github.louistsaitszho.loft.schedule.ScheduleFragment
import io.github.louistsaitszho.loft.tasks.ToDoFragment

class MainPagerAdapter(
        fragmentManager: FragmentManager,
        val context: Context,
        //TODO make it public var or something to allow runtime re-ordering
        private val pageOrder: List<Page> = listOf(
                Page.CHAT,
                Page.NOTE,
                Page.TO_DO,
                Page.SCHEDULE,
                Page.MEMBER,
                Page.MORE
        )
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = when (pageOrder[position]) {
        Page.CHAT -> ChatFragment()
        Page.NOTE -> NotesFragment()
        Page.TO_DO -> ToDoFragment()
        Page.SCHEDULE -> ScheduleFragment()
        Page.MEMBER -> MembersFragment()
        Page.MORE -> MoreFragment()
    }

    override fun getCount() = Page.values().size

    override fun getPageTitle(position: Int): CharSequence? = when (pageOrder[position]) {
        Page.CHAT -> context.getString(R.string.tab_title_chat)
        Page.NOTE -> context.getString(R.string.tab_title_notes)
        Page.TO_DO -> context.getString(R.string.tab_title_to_do)
        Page.SCHEDULE -> context.getString(R.string.tab_title_schedule)
        Page.MEMBER -> context.getString(R.string.tab_title_members)
        Page.MORE -> context.getString(R.string.tab_title_more)
    }
}

enum class Page {
    CHAT,
    NOTE,
    TO_DO,
    SCHEDULE,
    MEMBER,
    MORE
}