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
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        observeViewModels()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.findNextScene()
    }

    private fun observeViewModels() {
        viewModel.sceneAfterSplash.observe(this, Observer {
            when (it) {
                ONBOARDING ->
                    navigateToNextWithDelay(R.id.action_splashFragment_to_whatIsLoftFragment)
                MAIN ->
                    navigateToNextWithDelay(R.id.action_splashFragment_to_mainFragment)
                null -> TODO("This should not be possible, handle it when I got spare time")
            }
        })
    }

    private fun navigateToNextWithDelay(action: Int, delayMills: Long = 2000) {
        val delayHandler = Handler()
        delayHandler.postDelayed({ findNavController().navigate(action) }, delayMills)
    }
}
