package io.github.louistsaitszho.loft.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.ScopedFragment
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class SplashFragment : ScopedFragment() {

    private val viewModel: SplashViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onStart() {
        super.onStart()
        launch {
            val isSignedIn = async(Dispatchers.IO) { viewModel.isSignedIn() }
            val navigationAction = if (isSignedIn.await()) R.id.action_splashFragment_to_mainFragment
            else R.id.action_splashFragment_to_whatIsLoftFragment
            withContext(Dispatchers.Main) { navigateToNextWithDelay(action = navigationAction) }
        }
    }

    private fun navigateToNextWithDelay(action: Int, delayMills: Long = 2000) {
        val delayHandler = Handler()
        delayHandler.postDelayed({ findNavController().navigate(action) }, delayMills)
    }
}
