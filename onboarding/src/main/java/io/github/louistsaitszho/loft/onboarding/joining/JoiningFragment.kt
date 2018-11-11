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
package io.github.louistsaitszho.loft.onboarding.joining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.common.navigationDelegate.NavigationFragment
import io.github.louistsaitszho.loft.common.navigationDelegate.Transition
import io.github.louistsaitszho.loft.onboarding.R
import kotlinx.android.synthetic.main.fragment_joining.*
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class JoiningFragment : NavigationFragment() {

    val viewModel: JoiningViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_joining, container, false)
        observeAllLiveData()
        return view
    }

    private fun observeAllLiveData() {
        //TODO
    }

    override fun onStart() {
        super.onStart()
        fab_join_loft_confirm.setOnClickListener {
            //TODO check data, ask ViewModel to send it to api, some LD return different states
            navigationDelegate?.navigate(Transition.Joining2WaitForConfirmation())
        }
    }
}
