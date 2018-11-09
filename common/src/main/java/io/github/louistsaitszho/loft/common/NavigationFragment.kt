package io.github.louistsaitszho.loft.common

import android.content.Context
import android.support.v4.app.Fragment

/**
 * If your fragment needs access to Navigation action but are in another module, use this to ensure
 * that you will have access to the delegate to do so
 *
 * See [NavigationDelegate] on how the other side pick things up
 */
abstract class NavigationFragment : Fragment() {
    lateinit var navigationDelegate: NavigationDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NavigationDelegate) {
            navigationDelegate = context
        } else {
            throw NoNavigationDelegateException(this.javaClass.simpleName)
        }
    }
}
