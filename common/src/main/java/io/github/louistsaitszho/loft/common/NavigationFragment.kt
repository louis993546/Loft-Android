package io.github.louistsaitszho.loft.common

import android.content.Context
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment

/**
 * If your fragment needs access to Navigation action but are in another module, use this to ensure
 * that you will have access to the delegate to do so
 *
 * See [NavigationDelegate] on how the other side pick things up
 */
abstract class NavigationFragment : Fragment() {
    protected var navigationDelegate: NavigationDelegate? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NavigationDelegate) {
            navigationDelegate = context
        } else {
            throw NoNavigationDelegateException(this.javaClass.simpleName)
        }
    }

    /**
     * There's probably a reason why detach happen (activity is being destroy), and when that
     * happens, you DON'T want to be referencing the soon-to-be-dead activity and leak it. So
     * whenever fragment is being detach, also remove reference to the activity
     *
     * [CallSuper] is added to make sure any activity that override [onDetach] can't skip this
     */
    @CallSuper
    override fun onDetach() {
        super.onDetach()
        navigationDelegate = null
    }
}
