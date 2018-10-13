package io.github.louistsaitszho.loft.splash

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.louistsaitszho.loft.R
import timber.log.Timber

class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        super.onResume()
        Timber.d("splash resume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("splash paused")
    }
}
