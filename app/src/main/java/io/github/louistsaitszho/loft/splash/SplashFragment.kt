package io.github.louistsaitszho.loft.splash

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.github.louistsaitszho.loft.R
import kotlinx.coroutines.experimental.*
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModelLazily()
    private val runningJobs = mutableListOf<Job>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onStart() {
        super.onStart()

        val navigationJob = GlobalScope.launch {
            val navigationAction = withContext(Dispatchers.IO) {
                if (viewModel.isSignedIn()) {
                    TODO("Not implemented")
                } else {
                    R.id.action_splashFragment_to_whatIsLoftFragment
                }
            }
            withContext(Dispatchers.Main) {
                navigateToNextWithDelay(action = navigationAction)
            }
        }

        runningJobs.add(navigationJob)
    }

    override fun onStop() {
        super.onStop()
        runningJobs.forEach { it.cancel() }
    }

    private fun navigateToNextWithDelay(action: Int, delayMills: Long = 2000) {
        val delayHandler = Handler()
        delayHandler.postDelayed({ findNavController().navigate(action) }, delayMills)
    }
}
