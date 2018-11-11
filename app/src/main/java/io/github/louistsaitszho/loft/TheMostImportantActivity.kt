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
package io.github.louistsaitszho.loft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import io.github.louistsaitszho.loft.common.navigationDelegate.NavigationDelegate
import io.github.louistsaitszho.loft.common.navigationDelegate.Transition

/**
 * This is the one and only activity in the app. Everything lives on Fragments, navigation via the
 * Navigation AAC, and this is the activity that hosts all of them.
 *
 * Other notes:
 * - I don't think I need to care about onSaveInstanceState here (at least for now)
 */
class TheMostImportantActivity : AppCompatActivity(), NavigationDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_most_important)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()

    override fun navigate(transition: Transition) {
        val actionId = when (transition) {
            is Transition.WhatIs2Enter -> R.id.action_whatIsLoftFragment_to_enterLoftFragment
            is Transition.Enter2Creation -> R.id.action_enterLoftFragment_to_creationFragment
            is Transition.Enter2Joining -> R.id.action_enterLoftFragment_to_joiningFragment
            is Transition.Joining2WaitForConfirmation ->
                R.id.action_joiningFragment_to_waitForConfirmationFragment
            is Transition.Creation2Main -> R.id.action_creationFragment_to_mainFragment
        }
        findNavController(R.id.nav_host_fragment).navigate(actionId)
    }
}
