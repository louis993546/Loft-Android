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
package io.github.louistsaitszho.loft.common.navigationDelegate

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
