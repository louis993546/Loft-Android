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
package io.github.louistsaitszho.loft.splash

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.splash.SplashViewModel.SceneAfterSplash.MAIN
import io.github.louistsaitszho.loft.splash.SplashViewModel.SceneAfterSplash.ONBOARDING
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private val vm: SplashViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        observeViewModels()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.findNextScene()
    }

    private fun observeViewModels() {
        vm.sceneAfterSplash.observe(this, Observer {
            when (it) {
                ONBOARDING ->
                    navigateToNextWithDelay(R.id.action_splashFragment_to_whatIsLoftFragment)
                MAIN ->
                    navigateToNextWithDelay(R.id.action_splashFragment_to_mainFragment)
                null -> TODO("This should not be possible, handle it when I got spare time")
            }
        })
    }

    private fun navigateToNextWithDelay(action: Int, delayMills: Long = 1000) {
        val delayHandler = Handler()
        delayHandler.postDelayed({ findNavController().navigate(action) }, delayMills)
    }
}
