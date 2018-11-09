package io.github.louistsaitszho.loft.common

import android.content.Context
import android.support.v4.app.Fragment

/**
 * If your fragment needs access to Navigation action but are in another module, use this to ensure
 * that you will have access to the delegate to do so
 */
abstract class NavigationFragment : Fragment() {
    lateinit var navigationDelegate: NavigationDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NavigationDelegate) {
            navigationDelegate = context
        } else {
            TODO("Make a custom error or something to be clear what this is suppose to do")
        }
    }
}