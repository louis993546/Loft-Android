package io.github.louistsaitszho.loft.onboarding.enterLoft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.common.navigationDelegate.NavigationFragment
import io.github.louistsaitszho.loft.common.navigationDelegate.Transition
import io.github.louistsaitszho.loft.onboarding.R
import kotlinx.android.synthetic.main.fragment_enter_loft.*

class EnterLoftFragment : NavigationFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_loft, container, false)
    }

    override fun onStart() {
        super.onStart()
        fab_create_loft.setOnClickListener {
            navigationDelegate?.navigate(Transition.Enter2Creation())
        }
        fab_join_loft.setOnClickListener {
            navigationDelegate?.navigate(Transition.Enter2Joining())
        }
    }
}