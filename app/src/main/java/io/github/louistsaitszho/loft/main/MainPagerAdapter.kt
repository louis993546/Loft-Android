/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.louistsaitszho.loft.main

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.chat.ChatFragment
import io.github.louistsaitszho.loft.events.EventsFragment
import io.github.louistsaitszho.loft.members.MembersFragment
import io.github.louistsaitszho.loft.more.MoreFragment
import io.github.louistsaitszho.loft.notes.NotesFragment
import io.github.louistsaitszho.loft.tasks.TasksFragment

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
        Page.TO_DO -> TasksFragment()
        Page.SCHEDULE -> EventsFragment()
        Page.MEMBER -> MembersFragment()
        Page.MORE -> MoreFragment()
    }

    override fun getCount() = Page.values().size

    override fun getPageTitle(position: Int): CharSequence? = when (pageOrder[position]) {
        Page.CHAT -> context.getString(R.string.tab_title_chat)
        Page.NOTE -> context.getString(R.string.tab_title_notes)
        Page.TO_DO -> context.getString(R.string.tab_title_tasks)
        Page.SCHEDULE -> context.getString(R.string.tab_title_schedule)
        Page.MEMBER -> context.getString(R.string.tab_title_members)
        Page.MORE -> context.getString(R.string.tab_title_more)
    }

    /**
     * This make it possible for [MainFragment] to send onActivityResult results to the fragment
     * that triggers it originally.
     */
    fun delegateOnActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            ChatFragment.CAMERA_REQUEST_CODE ->
                pageOrder.filter { it == Page.CHAT }.forEachIndexed { index, _ ->
                    getItem(index).onActivityResult(requestCode, resultCode, data)
                }
        }
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